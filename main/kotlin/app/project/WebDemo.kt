package app.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * @author steve
 */
@RestController
@SpringBootApplication
class WebDemo {
    @RequestMapping("/", method = arrayOf(RequestMethod.GET))
    fun hello(): String = "hello world!"
}

fun main(args: Array<String>) {
    runApplication<WebDemo>(*args)
}