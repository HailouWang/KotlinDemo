package Q_Coroutines

import kotlinx.coroutines.*

// 7、协程有点像守护线程，但并不会使进程保活
fun main() = runBlocking {
    GlobalScope.launch {
        // 启动1000个线程，输出.，如果是启动线程来输出，那么可能会发生OOM
        repeat(1000) {
            println("I'm Sleep $it")
            delay(500L)
        }
    }

    delay(1300L) // 在延迟后退出，线程退出
}