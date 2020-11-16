package app.demo.hello

import app.demo.coroutine.practice.Gender
import app.demo.oop.CourseEnum

/**
 * @author steve
 */

fun main() {
    val courseEnumA = CourseEnum.A("a")
    val genders = Gender.values()
    val gender = genders.get((Math.random() * genders.size).toInt() % genders.size)
    println(gender.name)
    println("student-0001".split("-").last())
}