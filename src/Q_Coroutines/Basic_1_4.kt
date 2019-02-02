package Q_Coroutines

import kotlinx.coroutines.*

// 4、作用域构建器
// 可以使用 coroutineScope 来创建新的协程作用域，并且所有已启动的子协程执行完毕前，不会结束
// runBlocking 和 coroutineScope的区别在于后者在等待所有子线程执行完毕时，不会阻塞当前线程
fun main() = runBlocking<Unit> {
    println("runBlocking 开始执行协程")
    launch {
        println("runBlocking 的子协程 开始执行")
        delay(2000L)
        println("runBlocking 的子协程 结束执行")
    }

    println("runBlocking middle....")

    coroutineScope {
        println("coroutineScope 开始执行协程")
        launch {
            println("coroutineScope 的子协程 开始执行")
            delay(2000L)
            println("coroutineScope 的子协程 结束执行")
        }
        delay(1000L)
        println("coroutineScope 结束执行协程") // 4.1、在内嵌的launch之前才会执行
    }

    println("runBlocking end....") // 4.2、在内嵌的launch之后才会执行
}
// 4.3、从这里可以看到，coroutineScope不会阻塞当前线程，runBlocking阻塞当前线程