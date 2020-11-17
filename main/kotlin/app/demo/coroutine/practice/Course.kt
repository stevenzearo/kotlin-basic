package app.demo.coroutine.practice

/**
 * @author steve
 */
class Course constructor(val id: String, var gradeId: String, var name: String, var courseScore: Float, var duration: Int){
    override fun toString(): String {
        return "Course(id='$id', gradeId='$gradeId', name='$name', courseScore=$courseScore, duration=$duration)"
    }
}