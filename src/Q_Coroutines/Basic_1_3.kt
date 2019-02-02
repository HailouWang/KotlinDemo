package Q_Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 3、结构化的并发，
// runBlocking 协程构建器将main函数转换成协程
// 直到 runBlocking 内的所有协程都执行完毕后，runBlocking才会结束
fun main() = runBlocking<Unit> {
    launch {
        delay(1000L)
        println("中国！")
    }
    println("你好，")
}