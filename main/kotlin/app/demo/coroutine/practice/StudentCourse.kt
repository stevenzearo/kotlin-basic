package app.demo.coroutine.practice

/**
 * @author steve
 */
class StudentCourse(val id: String, val studentId: String, val course: Course) {
    companion object {
        val TOTAL_SCORE: Float = 100f
        val PASSRATE: Float = 0.6f
    }

    private var learnedDuration: Int = 0
    private var score: Float = 0f

    suspend fun learn() {
        if (learnedDuration < course.duration) learnedDuration++
    }

    suspend fun practice(addedScore: Float) {
        if (score < TOTAL_SCORE)
            score += addedScore
    }

    suspend fun exam(score: Float) {
        if (isLearnedCompleted())
            this.score = score else
            throw Exception("course not learned complete")
    }

    fun getScore(): Float = score

    fun getLearnedDuration(): Int = learnedDuration

    fun isLearnedCompleted(): Boolean = learnedDuration.equals(course.duration * PASSRATE)

    fun isFinished(): Boolean = score >= TOTAL_SCORE * PASSRATE

    override fun toString(): String {
        return "StudentCourse(id='$id', studentId='$studentId', course=$course, learnedDuration=$learnedDuration, score=$score)"
    }
}