package app.demo.coroutine.practice

/**
 * @author steve
 */
class ClassRoom(val id: String, var name: String) {
    var gradeId: String? = null
    val students: MutableList<Student> = mutableListOf()


    fun addStudents(vararg students: Student) {
        this.students.addAll(students)
    }

    fun removeStudents(vararg students: Student) {
        this.students.removeAll(students)
    }

    fun graduate() {
        students.clear()
    }
}