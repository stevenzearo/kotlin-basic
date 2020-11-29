package app.demo.coroutine.practice

/**
 * @author steve
 */
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.random.Random

class School constructor(val name: String, val grades: MutableList<Grade>) {
    var hiredTeachers: List<Teacher> = listOf()
    var recruitedStudents: List<Student> = listOf()

    suspend fun hireTeacher(): Unit {
        hiredTeachers = (1..100).map({ i -> Teacher("teacher-$i", "teacher-name-$i") }).toList()
    }

    suspend fun recruitStudent(): Unit {
        recruitedStudents = (1..10000).map { i ->
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
        val default = Random.Default
        val classRooms = grades.map { grade -> grade.classRoomMap }.flatMap { cr -> cr.values }.toList()
        students.forEachIndexed({ studentIndex, student ->
            val grade = grades.get(default.nextInt(0, grades.size))
            student.gradeId = grade.id
            student.courses = grade.courses.mapIndexed({ gradeIndex, course ->
                StudentCourse(
                    "student-course-${studentIndex * gradeIndex + studentIndex + gradeIndex}",
                    student.id,
                    course
                )
            }).toMutableList()

            var hasClassRoom: Boolean = false
            while (!hasClassRoom) {
                val classRoomId = classRooms.get(default.nextInt(0, classRooms.size)).id
                hasClassRoom = grade.setClassRoomForStudent(classRoomId, student)
            }
        })
    }

    suspend private fun dispatchTeacherClassRoom(teachers: List<Teacher>) {
        val classRooms = grades.map { grade -> grade.classRoomMap.values }.flatMap { classRooms -> classRooms }.toList()
        val courses = grades.map { grade -> grade.courses }.flatMap { courses -> courses }.toList()
        val teacherClassRoomsMap: MutableMap<Teacher, MutableList<ClassRoom>> = mutableMapOf()
        val teacherCoursesMap: MutableMap<Teacher, MutableList<Course>> = mutableMapOf()
        val default = Random.Default
        classRooms.forEachIndexed { index, classRoom ->
            val teacher = teachers.get(default.nextInt(0, teachers.size))
            val classRooms = teacherClassRoomsMap.get(teacher)
            if (classRooms == null) {
                teacherClassRoomsMap.put(teacher, mutableListOf(classRoom))
            } else {
                classRooms.add(classRoom)
            }
        }
        courses.forEachIndexed { index, course ->
            val teacher = teachers.get(default.nextInt(0, teachers.size))
            val courses = teacherCoursesMap.get(teacher)
            if (courses == null) {
                teacherCoursesMap.put(teacher, mutableListOf(course))
            } else {
                courses.add(course)
                teacherCoursesMap.put(teacher, courses)
            }
        }

        teacherCoursesMap.forEach(forEach@{ teacher, courses ->
            val classRooms = teacherClassRoomsMap.get(teacher)
            if (classRooms == null) return@forEach

            courses.forEachIndexed({ index, course ->
                val classRoom = classRooms.get(default.nextInt(0, classRooms.size))
                teacher.addTeachingClass(classRoom, course)
            })
        })
    }

    suspend private fun startClasses(teachers: List<Teacher>, scope: CoroutineScope): Job {
        return scope.launch {
            val classRooms = grades.map { grade -> grade.classRoomMap.map { classRoomMap -> classRoomMap.value } }
                .flatMap { classRooms -> classRooms }.toList()
            classRooms.forEach({ classRoom ->
                val teacher =
                    teachers.firstOrNull({ teacher -> teacher.teachingClassMap.containsKey(classRoom.id) })
                val grade = grades.filter { grade -> grade.id.equals(classRoom.gradeId) }.first()
                teacher!!.teachingClassMap.get(classRoom.id)!!.filter { course -> course.gradeId.equals(grade) }
                    .forEach({ course ->
                        (1..20).forEach({ teacher.teach(classRoom, course) })
                    })
            })
        }
    }

    fun printStudentCurrentCourseInfo() {
        recruitedStudents.forEach({ student -> println(student) })
    }

    fun run(scope: CoroutineScope): Job {

        return scope.launch {
            hireTeacher()
            recruitStudent()
            dispatchTeacherClassRoom(hiredTeachers)
            setGradeForStudent(recruitedStudents)
            val startClassesJob: Job = startClasses(hiredTeachers, this)
        }
    }

    suspend fun stopRun(scope: CoroutineScope, job: Job) {
        if (job.isActive) job.cancel()
    }
}

fun main(): Unit {
    val job = GlobalScope.launch {
        val grades = (1..10).map { i ->
            val grade = Grade("grade-$i", "grade-name-$i")
            grade.courses.addAll(
                (1..10).map({ j ->
                    Course(
                        "course-${i * j + i + j}",
                        grade.id,
                        "course-name-${i * j + i + j}",
                        100f,
                        20
                    )
                }).toMutableList()
            )
            (1..5).map({ j -> ClassRoom("class-room-${i * j + i + j}", "class-room-name-${i * j + i + j}") })
                .forEach({ classRoom ->
                    classRoom.gradeId = grade.id
                    grade.classRoomMap.put(classRoom.id, classRoom)
                })
            return@map grade
        }.toMutableList()
        val school = School("a-fake-school", grades)

        val run = school.run(this)
//    job.start()
        var isComplete = false
/*
    while (!isComplete) {
        if (!job.isCompleted && !job.isCancelled) {
            Thread.sleep(500)
        } else {
            isComplete = true
        }
    }
*/
        school.printStudentCurrentCourseInfo()
    }

    Thread.sleep(50000)
}