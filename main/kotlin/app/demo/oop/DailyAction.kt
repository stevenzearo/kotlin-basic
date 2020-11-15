package app.demo.oop

/**
 * @author steve
 */
interface DailyAction {
    fun greeting(name: String): String
    fun eating(): String
    fun sleeping(): String
}

fun DailyAction.additionalAction(): String {
    return "calling additional action in ${this.javaClass.canonicalName}"
}