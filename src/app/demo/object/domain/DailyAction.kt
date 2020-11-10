package app.demo.`object`.domain

/**
 * @author steve
 */
interface DailyAction {
    fun greeting(name: String): String
    fun eating(): String
    fun sleeping(): String
}