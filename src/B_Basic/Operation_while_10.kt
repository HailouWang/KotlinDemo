package B_Basic

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    var x: Int = 10

    //一、while循环的使用语法
    while (x > 0) {
        println("while ---> x $x")
        x--
    }

    var y: Int = 10
    //二、do-while循环使用语法
    do {
        println("do-while ---> y $y")
        y--
    } while (y > 0)
}