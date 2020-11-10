package app.demo.oop

/**
 * @author steve
 */

class Student private constructor(override val name: String, override val gender: Gender) : Person(),
    DailyAction {
    var id: String? = null
    var score: Float? = null
    override var age: Int = 0

    constructor(id: String, name: String, age: Int, gender: Gender, score: Float) : this(name, gender) {
        this.id = id
        this.age = age
        this.score = score
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