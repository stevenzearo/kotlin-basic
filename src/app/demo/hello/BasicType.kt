package app.demo.hello

import kotlin.reflect.typeOf

/**
 * @author steve
 */

fun main() {
    val byteMax: Byte = Byte.MAX_VALUE
    println("max byte value:$byteMax")
    val byteMin: Byte = Byte.MIN_VALUE
    println("min byte value:$byteMin")
    val byte1: Byte = 127
    val byte2: Byte = 127
    println("byte1 is equal to byte2 ? ${byte1 === byte2}")

    val shortMax: Short = Short.MAX_VALUE
    println("max short value:$shortMax")
    val shortMin: Short = Short.MIN_VALUE
    println("min short value:$shortMin")
    val short1: Short = 128.toShort()
    val short2: Short = 128.toShort()
    println("short1 is equal to short2 ? ${short1 === short2}")
    println(10000 - 10 === 10000 - 10)

    println(128 is Int)
    println(128.0 is Double)
    println(128.0f is Float)
}