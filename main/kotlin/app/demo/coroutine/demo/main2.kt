package app.demo.coroutine.demo

/**
 * @author steve
 */

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(100)
        println("world!")
    }

    job.join()
    helloCoroutine(job)
    delay(500)
}

private fun helloCoroutine(job: Job) {
    print("hello, ")
    job.start()
    print("hello, ")
}