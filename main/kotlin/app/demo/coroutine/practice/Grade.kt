package app.demo.coroutine.practice

/**
 * @author steve
 */
class Grade(val id: String, var name: String) {
    val classRoomMap: MutableMap<String, ClassRoom> = mutableMapOf()
    val courses: MutableList<Course> = mutableListOf()

    public fun setClassRoomForStudent(classRoomId: String, student: Student): Boolean {
        val classRoom = classRoomMap.get(classRoomId)
        if (classRoom != null) {
            classRoom.gradeId = id;
            classRoom.addStudent(student)
            return true
        }
        return false
    }
}