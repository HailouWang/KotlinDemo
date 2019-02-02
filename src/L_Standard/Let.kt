package L_Standard

/**
 * Let：返回值为函数块的最后一行或者指定return表达式，对象作为函数内部参数 可以通过it来代指，不存在$this
 */
fun main(args: Array<String>) {
    var a = 1.let {
        println("a run start --------------- $it")
        2
        3
        4
        'g'
    }

    var b = "string".let {
//        println("b run start --------------- $this")
        2
        3
        4
        'g'
        println("b run end ---------------")
    }

    println("a is $a b is : $b")
}