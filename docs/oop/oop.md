# Kotlin OOP
### 类定义
```kotlin
class Student constructor(val id: String, var name: String, var age: Int) {
    var score: Float = 0f
    var courses: Array<String> = [] 


    constructor(id: String, name: String, age: Int, score: Float): this(id, name, age) {
        this.score = score
    }

    fun addCourse(course: String) {
        this.courses
}
}
```
### 枚举
```kotlin
enum class Gender {
MALE,
FEMALE
}
```