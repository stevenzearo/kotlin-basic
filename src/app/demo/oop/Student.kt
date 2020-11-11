package app.demo.oop

/**
 * @author steve
 */

class Student private constructor(override val name: String, override val gender: Gender) : Person(),
    DailyAction {
    var id: String? = null
    var className: String? = null
    var courses: Array<String> = arrayOf()
    var score: Float? = null
    override var age: Int = 0

    constructor(id: String, name: String, age: Int, gender: Gender, className: String) : this(name, gender) {
    constructor(id: String, name: String, age: Int, gender: Gender, score: Float) : this(name, gender) {
        this.id = id
        this.age = age
        this.score = score
    }

    fun hasCourse(course: String): Boolean = courses.contains(course)

    fun addCourse(course: String): Boolean {
        if (courses.contains(course)) return false
        courses[courses.size] = course
        return true
    }

    fun removeCourse(course: String): Boolean {
        if (courses.contains(course)) {
            courses.drop(courses.indexOf(course))
            return true
        }
        return false
    }

    fun setScore(score: Float): Unit {
        this.score = score
    }

    override fun greeting(name: String): String {
        return "hello $name, I'm ${this.name}, I'm a student."
    }

    override fun eating(): String {
        return "$name is eating..."
    }

    override fun sleeping(): String {
        return "$name is sleeping..."
    }
}