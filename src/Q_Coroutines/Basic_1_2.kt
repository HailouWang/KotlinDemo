package Q_Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val job = GlobalScope.launch {
    delay(1000L)
    println("中国！")
}


fun main() = runBlocking<Unit> {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
    delay(2000L)
    println("你好,")
    job.join()
}