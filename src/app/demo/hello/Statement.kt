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
}