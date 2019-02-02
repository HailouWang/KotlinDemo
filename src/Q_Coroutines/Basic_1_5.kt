package Q_Coroutines

import kotlinx.coroutines.*

// 5、提取函数重构
fun main() = runBlocking<Unit> {
    println("runBlocking 开始执行协程")
    launch {
        printlnWorld()
        println("Hello,")
    }
}

suspend fun printlnWorld() {
    delay(1000L)
    println("World!")
}