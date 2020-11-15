package app.demo.hello

/**
 * @author steve
 */

fun intReduceOperation(operation: (a: Int, b: Int) -> Int, a: Int, vararg nums: Int): Int {
    var result: Int = a
    for (elem in nums) result = operation(result, elem)
    return result
}

fun main() {
    val f1: (Int, Int) -> Int = { x, y -> x + y } // lambda statement
    val f2 = fun(x: Int, y: Int): Int = x * y
    val result1 = intReduceOperation(f1, 0, 1, 2, 3, 4, 5)
    val result2 = intReduceOperation(f2, 1, 1, 2, 3, 4, 5)
    println("result1: $result1")
    println("result2: $result2")
}