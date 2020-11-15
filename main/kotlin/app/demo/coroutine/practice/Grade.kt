package app.demo.coroutine.practice

/**
 * @author steve
 */
class Grade(val id: String, var name: String) {
    val classRooms: MutableList<ClassRoom> = mutableListOf()
    val courses: MutableList<Course> = mutableListOf()

    private fun setClassRoomForStudent(classRoomId: String, students: Array<Student>) {
    }
}