package B_Basic

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    var a: Int = 8
    var b: Int = 2
    //一、if是一个表达式，即：它会返回一个值。因此也Kotlin也不需要三目运算符
    //sample start
    var max = a
    //1.1、if形态
    if (a < b) max = b

    //1.2、if-else形态
    if (a > b) {
        max = a
    } else {
        max = b
    }
    //1.3、作为表达式
    max = if (a > b) a else b

    //1.4、代码块
    max = if (a > b) {
        println("choose a")
        a
    } else {
        println("choose b")
        b
    }
    // sample end
}