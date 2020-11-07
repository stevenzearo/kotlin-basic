package app.demo.hello

/**
 * @author steve
 */

fun main() {
    // for statement
    for (i in 1..10) println("i = $i")
    println("----------------------")
    for (i in 1 until 10) println("i = $i")
    println("----------------------")
    for (i in 10 downTo 1) println("i = $i")
    println("----------------------")
    for (i in 10 downTo 1 step 2) println("i = $i")
    println("----------------------")
    val strings = arrayOf("a", "b", "c")
    for (s in strings.withIndex()) println("element = $s")
    println("----------------------")

    for ((index, s) in strings.withIndex()) println("index = $index, element = $s")
    println("----------------------")
    // while statement
    var i = 0
    while (i < 10) {
        if (i % 2 != 0) println("odd: $i")
        i++
    }

    // do while statement
    var x = 0
    do {
        println(x)
        x++
    } while (x < 10)

    // when statement
    var isContinue = true
    do {
        print("please input something here:")
        val s = readLine().toString()
        when (s.trim()) {
            "hello" -> println("hello, world!")
            "" -> println("Illegal input!!!")
            else -> println("hello, $s!")
        }
        println("Is continue?")
        isContinue = readLine().toString().toUpperCase().equals("Y")
    } while (isContinue)
}