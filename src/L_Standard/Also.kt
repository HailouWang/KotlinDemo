package L_Standard

/**
 * Also:将自身作为函数的参数，在函数块内可以通过it指代本对象，返回值为自身。
 */
fun main(args: Array<String>) {
    var a = 1.also {
        println("a run start ---------------")
        2
        3
        4
        'g'
    }

    var b = "string".also {
        println("b run start --------------- $it")
        2
        3
        4
        'g'
        println("b run end ---------------")
    }

    println("a is $a b is : $b")
}