package app.demo.oop

/**
 * @author steve
 */

fun main() {
    val s = Student(
        "id-001",
        "howard",
        12,
        Gender.MALE,
        23.6f
    )
    s.setScore(34.5f);
    println(s.greeting("steve"))
    println(s.eating())
    println(s.sleeping())
    println("score: ${s.score}")
    println("age: ${s.age}")
    s.growing()
    println("age: ${s.age}")
    println(s.additionalAction())
    try {
        throw NullPointerException("a null point exception")
    } catch (e: Exception) {
        println(e.printStackTrace())
    }
}