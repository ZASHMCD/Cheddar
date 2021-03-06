package co.adrianblan.storyfeed

import androidx.compose.runtime.Immutable
import co.adrianblan.core.DecoratedStory
import co.adrianblan.domain.StoryType

@Immutable
data class StoryFeedViewState(
    val storyType: StoryType,
    val storyFeedState: StoryFeedState,
    val isLoadingMorePages: Boolean,
    val hasLoadedAllPages: Boolean
)

@Immutable
sealed class StoryFeedState {
    data class Success(val stories: List<DecoratedStory>) : StoryFeedState()
    object Loading : StoryFeedState()
    data class Error(val throwable: Throwable) : StoryFeedState()
}