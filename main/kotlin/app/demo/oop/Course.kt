package app.demo.oop

/**
 * @author steve
 */
enum class Course constructor(val id: Int) {
    ENGLISH(1),
    MATH(2, "math");

    open var score: Float = 1f

    constructor(id: Int, name: String) : this(id)

    companion object A {
        val id: String = "a"
    }

    class B {
        val id: String = "a"
    }
}

fun main() {
    Course.MATH.score = 2.5f
}