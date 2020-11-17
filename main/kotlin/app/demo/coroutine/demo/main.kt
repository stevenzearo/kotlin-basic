package app.demo.coroutine.demo

/**
 * @author steve
 */

import kotlinx.coroutines.*

fun main() {
    val thread = Thread {
        Thread.sleep(100)
        println("world!")
    }

    val job = GlobalScope.launch {
        delay(100)
        println("world!")
    }

    helloCoroutine(job)
    println("--------")
    helloThread(thread)
    Thread.sleep(500)
}

private fun helloThread(thread: Thread) {
    print("hello, ")
    thread.start()
    print("hello, ")
}
private fun helloCoroutine(job: Job) {
    print("hello, ")
    job.start()
    print("hello, ")
}