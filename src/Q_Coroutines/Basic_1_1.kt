package Q_Coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
    // 1、输出：Hello, World!
    // 在后台启动一个新的协程并继续
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
    Thread.sleep(2000L)

    // 2、协程是轻量级的线程，将GlobalScope.launch --> thread,
    // delay --> sleep可以达到一样的目的
    // delay:是一个特殊的挂起函数，不会造成线程阻塞，会挂起协程
    // sleep：阻塞
    thread {
        Thread.sleep(1000L)
        println("中国!")
    }

    println("你好,")
    Thread.sleep(2000L)

    // 3、使用runBlocking：调用了runBlocking，主线程会一直阻塞到runBlocking内部的协程执行完毕
    println("runBlocking 开始执行")
    runBlocking {
        delay(2000L)
    }
    println("runBlocking 执行完毕")
}