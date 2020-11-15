package app.demo.coroutine.practice

/**
 * @author steve
 */
class Student constructor(val id: String, var name: String, var age: Int, var gender: Gender) {
    var courses: MutableList<StudentCourse> = mutableListOf()
    var gradeId: String? = null
    var classRoomId: String? = null
    fun isGraduated(): Boolean = courses.map { course -> course.isFinished() }.reduce { b1, b2 -> b1 && b2 }
}