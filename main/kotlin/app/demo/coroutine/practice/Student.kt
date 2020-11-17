package app.demo.coroutine.practice

/**
 * @author steve
 */
class Student constructor(val id: String, var name: String, var age: Int, var gender: Gender) {
    var courses: MutableList<StudentCourse> = mutableListOf()
    var gradeId: String? = null
    var classRoomId: String? = null

    suspend fun learn(course: Course) {
        if (!courses.map { studentCourse ->  studentCourse.course.id}.contains(course.id)) return
        val studentCourse = courses.filter { studentCourse -> studentCourse.course.id.equals(course.id) }.first()
        studentCourse.learn()
    }

    suspend fun practice(course: Course, addedScore: Float) {
        if (!courses.map { studentCourse ->  studentCourse.course.id}.contains(course.id)) return
        val studentCourse = courses.filter { studentCourse -> studentCourse.course.id.equals(course.id) }.first()
        studentCourse.practice(addedScore)
    }

    fun isGraduated(): Boolean = courses.map { course -> course.isFinished() }.reduce { b1, b2 -> b1 && b2 }

    override fun toString(): String {
        return "Student(id='$id', name='$name', age=$age, gender=$gender, courses=$courses, gradeId=$gradeId, classRoomId=$classRoomId)"
    }
}