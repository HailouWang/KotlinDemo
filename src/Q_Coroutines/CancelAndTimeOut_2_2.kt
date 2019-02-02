package Q_Coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    //    val startTime = System.currentTimeMillis()
//
//    // 1、如果协程正在执行计算任务，并且没有检查取消的话，那么它是不能被取消的
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        while (i < 5) { // 一个执行计算的循环，只是为了占用 CPU
//            // 每秒打印消息两次
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//    delay(1300L) // 等待一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消一个任务并且等待它结束
//    println("main: Now I can quit.")


    // 2、改进：
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        while (isActive) { // 可以被取消的计算循环
//            // 每秒打印消息两次
//            if (System.currentTimeMillis() >= nextPrintTime) {
//                println("I'm sleeping ${i++} ...")
//                nextPrintTime += 500L
//            }
//        }
//    }
//    delay(1300L) // 等待一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该任务并等待它结束
//    println("main: Now I can quit.")


    // 3、在finally中处理释放资源的操作
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                delay(500L)
//            }
//        } finally {
//            println("I'm running finally")
//        }
//    }
//    delay(1300L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该任务并且等待它结束
//    println("main: Now I can quit.")


    // 4、使用withContext和不使用，输出差异如下：
    /**
     * 使用：
     *I'm sleeping 0 ...
     * I'm sleeping 1 ...
     * I'm sleeping 2 ...
     * main: I'm tired of waiting!
     * I'm running finally
     * And I've just delayed for 1 sec because I'm non-cancellable
     * main: Now I can quit.
     *
     * 不使用：
     * I'm sleeping 0 ...
     * I'm sleeping 1 ...
     * I'm sleeping 2 ...
     * main: I'm tired of waiting!
     * I'm running finally
     * main: Now I can quit.
     */
//    val job = launch {
//        try {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                delay(500L)
//            }
//        } finally {
//            withContext(NonCancellable) {
//                println("I'm running finally")
//                delay(1000L)
//                println("And I've just delayed for 1 sec because I'm non-cancellable")
//            }
//        }
//    }
//    delay(1300L) // 延迟一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消该任务并等待它结束
//    println("main: Now I can quit.")

    // 5、timeOut
//    withTimeout(1300L) {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }

    // 6、改进
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done" // 在它运行得到结果之前取消它
    }
    println("Result is $result")
}