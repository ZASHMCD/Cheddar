package co.adrianblan.ui.node

import co.adrianblan.common.MutableStateFlow
import co.adrianblan.common.StateFlow

/** A Router is used by a parent Node to attach and detach child Nodes */
interface Router {
    val state: StateFlow<List<AnyNode>>
    fun onBackPressed(): Boolean
}

class StackRouter constructor(
    initialState: List<AnyNode>
) : Router {

    override val state: MutableStateFlow<List<AnyNode>> =
        MutableStateFlow(initialState)

    fun push(node: AnyNode) {
        state.offer(state.value + node)
    }

    fun pop() {

        val nodes: MutableList<AnyNode> = state.value.toMutableList()

        nodes.removeAt(nodes.size - 1)
            .apply {
                detach()
            }

        state.offer(nodes)
    }

    private fun canPop() = state.value.size > 1

    override fun onBackPressed(): Boolean {
        // Iterate through stack of children, see if any children handle it
        state.value.reversed()
            .forEach { node ->
                if (node.onBackPressed()) {
                    return true
                }
            }

        return if (canPop()) {
            pop()
            true
        } else false
    }
}