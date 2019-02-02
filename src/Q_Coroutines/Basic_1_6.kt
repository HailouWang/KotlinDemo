package Q_Coroutines

import kotlinx.coroutines.*

// 6、协程比线程轻量
fun main() = runBlocking<Unit> {
    // 启动1000个线程，输出.，如果是启动线程来输出，那么可能会发生OOM
    repeat(1000) {
        delay(500L)
        println(".")
    }
}