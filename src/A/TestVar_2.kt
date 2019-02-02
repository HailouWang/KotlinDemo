package A

/**
 * 综述：
 *
 * 定义变量相关的事项
 *
 * 关键字：
 * 只读：val
 * 可变：var
 */

//三、顶层变量   问题：全局变量？
//sample start
var PI = 3.14
var y = 0

fun incrementX(){
    y += 1
}
//sample end

fun main(args: Array<String>) {
    //一、定义'局部变量'类型，相关的注意事项
    //sample start
    var a: Int = 1 //立即赋值
    var b = 2 //根据赋值，自动推断出类型Int
    var c: Int //如果没有初始值类型，则类型不能省略
    c = 3
    //sample end

    println(" a --> $a, b --> $b, c --> $c")

    //------------------------------

    //二、变量
    //sample start
    var x = 5 //根据赋值，自动推断出类型Int
    x += 1

    println(" x --> " + x)

    //------------------------------

    println("y = $y , PI = $PI")
    incrementX()
    println("y = $y , PI = $PI")
}