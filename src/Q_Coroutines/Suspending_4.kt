package Q_Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    // 1、async
    // async 就类似于 launch。它启动了一个单独的协程，这是一个轻量级的线程并与其它所有的协程一起并发的工作。
    // 不同之处在于 launch 返回一个 Job 并且不附带任何结果值，而 async 返回一个 Deferred —— 一个轻量级的非阻塞 future，
    // 这代表了一个将会在稍后提供结果的 promise。你可以使用 .await() 在一个延期的值上得到它的最终结果，
    // 但是 Deferred 也是一个 Job，所以如果需要的话，你可以取消它。
//    val time = measureTimeMillis {
//        val one = async { doSomethingUsefulOne() }
//        val two = async { doSomethingUsefulTwo() }
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")

    // 2、惰性启动的 async
    // 使用一个可选的参数 start 并传值 CoroutineStart.LAZY，可以对 async 进行惰性操作。 只有当结果需要被 await 或者如果一个 start 函数被调用，协程才会被启动。

    // 如果我们在 println 中调用了 await 并且在这个协程中省略调用了 start，接下来 await 会开始执行协程并且等待协程执行结束，
    // 因此我们会得到顺序的行为，但这不是惰性启动的预期用例。 当调用挂起函数计算值的时候 async(start = CoroutineStart.LAZY) 用例是标准的 lazy 函数的替换方案。
//    val time = measureTimeMillis {
//        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
//        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
//        // 执行一些计算
//        one.start() // 启动第一个
//        two.start() // 启动第二个
//        println("The answer is ${one.await() + two.await()}")
//    }
//    println("Completed in $time ms")

    // 3、async 风格的函数
    // 这些 xxxAsync 函数不是 挂起 函数。它们可以在任何地方被使用。 然而，它们总是在调用它们的代码中意味着异步（这里的意思是 并发 ）执行。
    val time = measureTimeMillis {
        // 我们可以在协程外面启动异步执行
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        // 但是等待结果必须调用其它的挂起或者阻塞
        // 当我们等待结果的时候，这里我们使用 `runBlocking { …… }` 来阻塞主线程
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")
}

// 3、它们只做异步计算并且需要使用延期的值来获得结果
// somethingUsefulOneAsync 函数的返回值类型是 Deferred<Int>
fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

// somethingUsefulTwoAsync 函数的返回值类型是 Deferred<Int>
fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // 假设我们在这里做了一些有用的事
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // 假设我们在这里也做了一些有用的事
    return 29
}