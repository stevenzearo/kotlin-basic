package app.demo.oop

import app.demo.oop.Gender

/**
 * @author steve
 */
abstract class Person {
    abstract val name: String
    abstract var age: Int
    abstract val gender: Gender
    fun growing(): Int = age++
}