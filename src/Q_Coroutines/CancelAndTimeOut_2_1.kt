package Q_Coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000) {
            println("I'm Sleep $it")
            delay(500L)
        }
    }

    delay(1300L)
    println("main:I'm tired of waiting!")
    job.cancel()
    job.join()
    println("main:Now I can quit.")
}