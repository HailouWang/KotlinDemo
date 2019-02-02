package L_Standard

/**
 * Run：返回值为函数块的最后一行或者指定return表达式
 */
fun main(args: Array<String>) {
    var a = run {
        println("a run start ---------------")
        2
        3
        4
        'g'
    }

    var b = "string".run {
        println("b run start --------------- $this")
        2
        3
        4
        'g'
        println("b run end ---------------")
    }

    println("a is $a b is : $b")
}