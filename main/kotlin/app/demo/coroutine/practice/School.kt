package app.demo.coroutine.practice

/**
 * @author steve
 */

class School constructor(val name: String, val grades: MutableList<Grade>) {
    fun hireTeacher(): List<Teacher> {
        return listOf()
    }

    fun recruitStudent(): List<Student> {
        return listOf()
    }

    private fun setGradeForStudent(students: List<Student>) {
    }

    private fun dispatchTeacherClassRoom(teachers: List<Teacher>) {

    }

    fun startClasses(teachers: List<Teacher>) {
        grades.forEach({ grade ->
            grade.classRooms.forEach({ classRoom ->
                val teacher = teachers.firstOrNull({ teacher -> teacher.teachingClassMap.containsKey(classRoom.id) })
                if (teacher != null) {
                    val teachingCouses = teacher.teachingClassMap.get(classRoom.id)
                    teachingCouses!!.forEach({ course ->
                        teacher.teach(classRoom, course)
                    })
                }
            }

            )
        })
    }

    fun run() {
        // todo coroutine
        val hiredTeachers = hireTeacher()
        val recruitedStudents = recruitStudent()
        dispatchTeacherClassRoom(hiredTeachers)
        setGradeForStudent(recruitedStudents)
        startClasses(hiredTeachers)
    }

    fun stopRun() {

    }
}