package app.demo.oop

/**
 * @author steve
 */

open class CourseClass private constructor() {
    constructor(id: Int, name: String): this() // secondary constructor have to call primary constructor
}

object CourseClassO : CourseClass(id = 1, name = "math")

fun main() {
    var courseClass = CourseClass(1, "math")
    CourseClassO
}