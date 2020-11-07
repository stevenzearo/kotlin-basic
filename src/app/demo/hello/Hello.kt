package app.demo.hello

/**
 * @author steve
 */
object Hello {
     fun greeting(name: String): String = "hello, $name."
}

fun main(args: Array<String>) {
    print("please input your name here:")
    val name: String = readLine().toString()
    println(Hello.greeting(name))
}