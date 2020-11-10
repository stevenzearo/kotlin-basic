package app.demo.`object`.domain

/**
 * @author steve
 */

class Student(name: String, gender: Gender) : Person(), DailyAction {
    override val name: String = ""
    override var age: Int = 0
    override val gender: Gender = Gender.MALE

    var id: String? = null
    var className: String?  = null

    constructor(id: String, name: String, age: Int, gender: Gender, className: String): this(name, gender) {
        this.id = id
        this.age = age
        this.className = className
    }

    fun getAId(): String? = id

    fun setAID(id: String): Unit {
        this.id = id
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