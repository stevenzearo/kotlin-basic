package app.demo.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

/**
 * @author steve
 */

class UnitTestDemo {
    @Test
    fun testSuspendingFunction() = runBlocking<Unit> {
        delay(100)
        val job = GlobalScope.launch {
            delay(100)
            print("world!")
        }
        print("hello, ")
        job.join()
    }
}