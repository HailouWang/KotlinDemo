package A

import java.io.File

//一、当某个变量可为null时，必须在声明处的类型后添加"？"
//来标识该引用可为空

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

//sample start
fun printProduct(args1: String, args2: String) {
    var x = parseInt(args1)
    var y = parseInt(args2)

    //直接使用x*y会导致编译错误，因为他们可能为null
//    println(" x --> $x, y --> $y, x*y --> ${x * y}")

    if (x != null && y != null) {
        println(" x --> $x,y --> $y,x*y --> ${x * y}")
    } else {
        println("either $args1 or '$args2' is not a number")
    }
}
//sample end

fun main(args: Array<String>) {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("6", "b")
    printProduct("a", "b")

    //二、在可能空的集合中，取第一个元素
    var files:Array<File> = File("Test").listFiles()
    val firstFile = files.firstOrNull()
}