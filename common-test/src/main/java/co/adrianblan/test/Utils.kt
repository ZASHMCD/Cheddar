package co.adrianblan.test

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun delayAndThrow(delayTime: Long): Nothing =
    coroutineScope {
        delay(delayTime)
        throw RuntimeException()
    }