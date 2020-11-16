package app.demo.coroutine.practice

/**
 * @author steve
 */
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class School constructor(val name: String, val grades: MutableList<Grade>) {
    suspend fun hireTeacher(): List<Teacher> {
        return (1..100).map({ i -> Teacher("teacher-$i", "teacher-name-$i") }).toList()
    }

    suspend fun recruitStudent(): List<Student> {
        return (1..10000).map { i ->
            val genders = Gender.values()
            Student(
                "student-$i",
                "student-name-$i",
                (Math.random() * 20).toInt(),
                genders.get((Math.random() * genders.size).toInt() % genders.size)
            )
        }.toList()
    }

    suspend private fun setGradeForStudent(students: List<Student>) {
        students.forEach({ student ->
            val i = student.id.split("-").last().toInt()
            val grade = grades.get(grades.size % i)
            student.gradeId = grade.id
            student.courses = grade.courses.mapIndexed({ index, course ->
                StudentCourse(
                    "student-course-&${i * index}",
                    student.id,
                    course
                )
            }).toMutableList()
            val classRoomId = grade.classRoomMap.entries.toTypedArray().get(grade.classRoomMap.size % i).value.id
            grade.setClassRoomForStudent(classRoomId, student)
        })
    }

    suspend private fun dispatchTeacherClassRoom(teachers: List<Teacher>) {
        val classRooms = grades.map { grade -> grade.classRoomMap.values }.flatMap { classRooms -> classRooms }.toList()
        val courses = grades.map { grade -> grade.courses }.flatMap { courses -> courses }.toList()
        val teacherClassRoomsMap: MutableMap<Teacher, MutableList<ClassRoom>> = mutableMapOf()
        val teacherCoursesMap: MutableMap<Teacher, MutableList<Course>> = mutableMapOf()
        classRooms.forEachIndexed { index, classRoom ->
            val teacher = teachers.get(teachers.size % index)
            val classRooms = teacherClassRoomsMap.get(teacher)
            if (classRooms == null) {
                teacherClassRoomsMap.put(teacher, mutableListOf(classRoom))
            } else {
                classRooms.add(classRoom)
            }
        }
        courses.forEachIndexed { index, course ->
            val teacher = teachers.get(teachers.size % index)
            val courses = teacherCoursesMap.get(teacher)
            if (courses == null) {
                teacherCoursesMap.put(teacher, mutableListOf(course))
            } else {
                courses.add(course)
            }
        }

        teacherCoursesMap.forEach(forEach@{ teacher, courses ->
            val classRooms = teacherClassRoomsMap.get(teacher)
            if (classRooms == null) return@forEach

            courses.forEachIndexed({ index, course ->
                val classRoom = classRooms.get(index % classRooms.size)
                teacher.addTeachingClass(classRoom, course)
            })
        })
    }

    suspend private fun startClasses(teachers: List<Teacher>) {
        grades.forEach({ grade ->
            grade.classRoomMap.forEach({ classRoomId, classRoom ->
                val teacher = teachers.firstOrNull({ teacher -> teacher.teachingClassMap.containsKey(classRoomId) })
                if (teacher != null) {
                    val teachingCouses = teacher.teachingClassMap.get(classRoomId)
                    teachingCouses!!.forEach({ course ->
                        teacher.teach(classRoom, course)
                    })
                }
            })
        })
    }

    fun run() {
        GlobalScope.launch {
            val hiredTeachers = hireTeacher()
            val recruitedStudents = recruitStudent()

            dispatchTeacherClassRoom(hiredTeachers)
            setGradeForStudent(recruitedStudents)
            startClasses(hiredTeachers)
        }
        // todo coroutine

    }

    fun stopRun() {

    }
}