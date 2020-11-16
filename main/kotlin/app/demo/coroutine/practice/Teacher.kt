package app.demo.coroutine.practice

/**
 * @author steve
 */

class Teacher constructor(val id: String, var name: String) {
    val teachingClassMap: MutableMap<String, MutableList<Course>> = mutableMapOf() // classRoomId -> Courses


    fun addTeachingClass(classRoom: ClassRoom, vararg courses: Course) {
        val classRoomId = classRoom.id
        if (teachingClassMap.containsKey(classRoomId)) {
            val teachCourses = teachingClassMap.get(classRoomId)!!
            teachCourses.addAll(courses)
        } else {
            teachingClassMap.put(classRoomId, courses.toMutableList())
        }
    }

    suspend fun teach(classRoom: ClassRoom, course: Course) {
        classRoom.students.forEach(foreach@{ student ->
            if (!student.courses.map { studentCourse: StudentCourse -> studentCourse.course.id }.toSet()
                    .contains(course.id)
            ) return@foreach
            val studentCourse =
                student.courses.filter { studentCourse -> studentCourse.course.id.equals(course) }.first()
            studentCourse.learn()
            studentCourse.practice((Math.random() * 10).toFloat())
        })
    }


}