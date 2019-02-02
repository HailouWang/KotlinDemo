package P_Others

fun main(args: Array<String>) {
    // 1、区间操作符，由 .. 和 in 和 !in操作符
    var i = 5
    if (i in 1..10) {
        println("if i : " + i)
    }

    // 2、for
    for (i in 5..9) {
        println("for i : " + i)
    }

    // 3、downTo
    for (i in 10 downTo 1) {
        println("downTo i : " + i)
    }

    // 4、step
    for (i in 1..6 step 2) {
        println("step i : " + i)
    }

    // 5、不包括结束区间
    for (i in 1 until 8) {
        println("until i : " + i)
    }

    // 6、一些函数
    val j = 10
    var x = j.rangeTo(15)
    println("rangeTo : " + x)
    for (i in x) {
        println("rangeTo i : " + i)
    }

    var x1 = j.downTo(2).step(2)
    println("downTo : " + x1)

    var x3 = j.downTo(3).reversed()
    println("reversed : " + x3)
}