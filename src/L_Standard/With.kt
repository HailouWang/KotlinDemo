package L_Standard

import java.lang.StringBuilder

/**
 * With：返回值为函数块的最后一行或者指定return表达式，外部对象作为函数参数
 */
fun main(args: Array<String>) {
    var a = with("String") {
        println("a run start ---------------")
        2
        3
        4
        'g'
        return
    }

    val string = StringBuilder().apply {
        append("123")
        append("123123")
    }.toString()



    println("a is $a")
}