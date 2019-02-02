package Q_Coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

fun main() = runBlocking {
    // 1、和BlockingQueue非常相似，它代替了阻塞的 put 操作并提供了挂起的 send，还替代了阻塞的 take 操作并提供了挂起的 receive。
//    val channel = Channel<Int>()
//    launch {
//        // 这里可能是消耗大量 CPU 运算的异步逻辑，我们将仅仅做 5 次整数的平方并发送
//        for (x in 1..5) channel.send(x * x)
//    }
//// 这里我们打印了 5 次被接收的整数：
//    repeat(5) { println(channel.receive()) }
//    println("Done!")

    // 2、关闭通道
//    val channel = Channel<Int>()
//    launch {
//        for (x in 1..5) channel.send(x * x)
//        channel.close() // 我们结束发送
//        channel.send(6 * 6)
//    }
//// 这里我们使用 `for` 循环来打印所有被接收到的元素（直到通道被关闭）
//    for (y in channel) println(y)
//    println("Done!")


    // 3、生产者
    // 可以将生产者抽象成一个函数，并且使通道作为它的参数，但这与必须从函数中返回结果的常识相违悖
//    val squares = produceSquares()
//    squares.consumeEach { println(it) }
//    println("Done!")

    // 4、管道是一种一个协程在流中开始生产可能无穷多个元素
//    val numbers = produceNumbers() // 从 1 开始生产整数
//    val squares = square(numbers) // 对整数做平方
//    for (i in 1..7) println(squares.receive()) // 打印前 5 个数字
//    println("Done!") // 我们的操作已经结束了
//    coroutineContext.cancelChildren() // 取消子协程

    // 5、管道filter循环工作
//    var cur = numbersFrom(2)
//    for (i in 1..10) {
//        val prime = cur.receive()
//        println(prime)
//        cur = filter(cur, prime)
//    }
//    coroutineContext.cancelChildren() // 取消所有的子协程来让主协程结束

    // 6、扇出：多个输出面，管道顺序出栈
//    val producer = produceNumbers1()
//    repeat(5) { launchProcessor(it, producer) }
//    delay(950)
//    producer.cancel() // 取消协程处理器从而将它们全部杀死


    // 7、扇入：多个输入源，按照时间顺序，往管道中发送数据
//    val channel = Channel<String>()
//    launch { sendString(channel, "foo", 200L) }
//    launch { sendString(channel, "BAR!", 500L) }
//    repeat(6) { // 接收前六个
//        println(channel.receive())
//    }
//    coroutineContext.cancelChildren() // 取消所有子协程来让主协程结束

    // 8、带缓冲的通道
    // 使用缓冲通道并给 capacity 参数传入 四 它将打印“sending” 五 次：
    // 前四个元素被加入到了缓冲区并且发送者在试图发送第五个元素的时候被挂起。
//    val channel = Channel<Int>(4) // 启动带缓冲的通道
//    val sender = launch { // 启动发送者协程
//        repeat(10) {
//            println("Sending $it") // 在每一个元素发送前打印它们
//            channel.send(it) // 将在缓冲区被占满时挂起
//        }
//    }
//// 没有接收到东西……只是等待……
//    delay(1000)
//    sender.cancel() // 取消发送者协程

    // 9、协程是公平的
    // “乒”协程首先被启动，所以它首先接收到了球。甚至虽然“乒” 协程在将球发送会桌子以后立即开始接收，但是球还是被“乓” 协程接收了，因为它一直在等待着接收球：
//    val table = Channel<Ball>() // 一个共享的table（桌子）
//    launch { player("ping", table) }
//    launch { player("pong", table) }
//    table.send(Ball(0)) // 乒乓球
//    delay(1000) // 延迟 1 秒钟
//    coroutineContext.cancelChildren() // 游戏结束，取消它们

    // 10、计时器通道是一种特别的会合通道，每次经过特定的延迟都会从该通道进行消费并产生 Unit。 虽然它看起来似乎没用，它被用来构建分段来创建复杂的基于时间的 produce 管道和进行窗口化操作以及其它时间相关的处理。 可以在 select 中使用计时器通道来进行“打勾”操作。
    val tickerChannel = ticker(delayMillis = 100, initialDelayMillis = 0) //创建计时器通道
    var nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Initial element is available immediately: $nextElement") // 初始尚未经过的延迟

    nextElement = withTimeoutOrNull(50) { tickerChannel.receive() } // 所有随后到来的元素都经过了100浩渺的延迟
    println("Next element is not ready in 50 ms: $nextElement")

    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 100 ms: $nextElement")

    // 模拟大量消费延迟
    println("Consumer pauses for 150ms")
    delay(150)
    // 下一个元素立即可用
    nextElement = withTimeoutOrNull(1) { tickerChannel.receive() }
    println("Next element is available immediately after large consumer delay: $nextElement")
    // 请注意，`receive` 调用之间的暂停被考虑在内，下一个元素的到达速度更快
    nextElement = withTimeoutOrNull(60) { tickerChannel.receive() }
    println("Next element is ready in 50ms after consumer pause in 150ms: $nextElement")

    tickerChannel.cancel() // 表明不再需要更多的元素
}

data class Ball(var hits: Int)

suspend fun player(name: String, table: Channel<Ball>) {
    for (ball in table) { // 在循环中接收球
        ball.hits++
        println("$name $ball")
        delay(300) // 等待一段时间
        table.send(ball) // 将球发送回去
    }
}

suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(s)
    }
}

fun CoroutineScope.produceNumbers1() = produce<Int> {
    var x = 1 // 从 1 开始
    while (true) {
        send(x++) // 产生下一个数字
        delay(100) // 等待 0.1 秒
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Int>) = launch {
    for (msg in channel) {
        println("Processor #$id received $msg")
    }
}

fun CoroutineScope.numbersFrom(start: Int) = produce<Int> {
    var x = start
    while (true) send(x++) // 开启了一个无限的整数流
}

fun CoroutineScope.filter(numbers: ReceiveChannel<Int>, prime: Int) = produce<Int> {
    for (x in numbers) if (x % prime != 0) send(x)
}

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) send(x * x)
}

// 在流中开始从 1 生产无穷多个整数
fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (true) send(x++) // 在流中开始从 1 生产无穷多个整数
}

// 另一个或多个协程开始消费这些流
fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}