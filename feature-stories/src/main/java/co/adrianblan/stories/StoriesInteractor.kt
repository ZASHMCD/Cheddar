package co.adrianblan.stories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import co.adrianblan.common.DispatcherProvider
import co.adrianblan.common.ParentScope
import co.adrianblan.ui.Interactor
import co.adrianblan.hackernews.HackerNewsRepository
import co.adrianblan.hackernews.api.Story
import co.adrianblan.hackernews.api.StoryId
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class StoriesInteractor
@Inject
constructor(
    private val hackerNewsRepository: HackerNewsRepository,
    override val dispatcherProvider: DispatcherProvider,
    @StoriesInternal override val parentScope: ParentScope
) : Interactor() {

    val viewState: LiveData<StoriesViewState> get() = _viewState

    private val _viewState by lazy {
        MutableLiveData<StoriesViewState>(
            StoriesViewState.Loading)
    }

    init {
        scope.launch {
            _viewState.value =
                try {
                    val storyIds: List<StoryId> =
                        withContext(dispatcherProvider.IO) {
                            hackerNewsRepository.fetchTopStories()
                        }

                    val stories: List<Story> =
                        flow {
                            storyIds
                                .take(10)
                                .forEach { storyId ->
                                    val story = hackerNewsRepository.fetchStory(storyId)
                                    emit(story)
                                }
                        }
                            .flowOn(dispatcherProvider.IO)
                            .toList()

                    StoriesViewState.Success(stories)
                } catch (t: Throwable) {
                    Timber.e(t)
                    StoriesViewState.Error
                }
        }
    }
}