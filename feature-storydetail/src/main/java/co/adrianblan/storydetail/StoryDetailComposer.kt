package co.adrianblan.storydetail

import co.adrianblan.ui.Composer
import kotlinx.coroutines.cancel
import javax.inject.Inject


class StoryDetailComposer
@Inject constructor(
    private val storyDetailInteractor: StoryDetailInteractor,
    @StoryDetailInternal private val listener: Listener
): Composer {

    interface Listener {
        fun onStoryDetailFinished()
    }

    override fun composeView() =
        StoryDetailScreen(
            viewState = storyDetailInteractor.viewState,
            onBackPressed = { listener.onStoryDetailFinished() }
        )

    override fun detach() =
        storyDetailInteractor.scope.cancel()
}