package M_tips

// 类型推断：和Sala一样，可以根据赋值来推断出变量类型
class Tips2_TypeInterface {

}

fun main(args: Array<String>) {
    // 1、如下 a 、 b 可自动被推断出  Int、String类型
    var a = 10
    var b = "10"

    // 2、智能转换类型
    var c: Any? = null
    if (c is String) {
        println("b length is : " + b.length)
    }

    if (c !is String) {
        return
    }
    // 自动推断出c为String
    c.length

    var d: Any? = null
    if (d !is String || d.length == 3) {

    }

    if (d is String && d.length == 4) {

    }

    when (d) {
        is Int -> println(d)
        is String -> println(d.length + 1)
        else -> println("其他")
    }
}