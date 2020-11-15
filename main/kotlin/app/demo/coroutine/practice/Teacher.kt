package app.demo.coroutine.practice

/**
 * @author steve
 */

class Teacher constructor(id: String, name: String) {
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

    fun teach(classRoom: ClassRoom, course: Course) {
        classRoom.students.forEach({ student ->

        })
    }


}