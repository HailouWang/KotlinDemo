package A

/**
 * 综述：
 * 定义函数及其函数中的各种事项。
 */

//一、定义函数，带有两个Int参数、一个Int类型的返回值
//sample start
fun sum1(a: Int, b: Int): Int {
    return a + b
}
//sample end

//二、将表达式作为函数体，返回值类型自动推断
//sample start
fun sum2(a: Int, b: Int) = a + b
//sumple end

//三、函数返回无意义的值
//sample start
fun printSum(a:Int,b:Int):Unit {
    println("sum of $a and $b is ${a+b}")
}
//sample end

//四、返回无意义的值中的Unit，可以忽略，即：
//sample start
fun printSumWithOutUnit(a:Int,b:Int){
    println("sum of $a and $b is : ${a+b}")
}
//sample end

fun main(args: Array<String>) {
    print("sum of 3 and 5 is :")
    println(sum1(3, 5))

    //-------------------------

    println("sum of 19 and 23 is : ${sum2(19, 23)}")

    //-------------------------
    printSum(-1,8)

    //-------------------------
    printSumWithOutUnit(-1,8)
}