package L_Standard

/**
 * Apply:在函数块内可以通过this指代本对象，返回值为自身
 */
fun main(args: Array<String>) {
    var a = 1.apply {
        println("a run start ---------------")
        2
        3
        4
        'g'
    }

    var b = "string".apply {
        println("b run start --------------- $this")
        2
        3
        4
        'g'
        println("b run end ---------------")
    }

    "aa".apply { this }
    "vv".also { it }

    println("a is $a b is : $b")
}