package A

fun main(args : Array<String>){
    //一、字符串模板
    //sample start
    var a = 1
    //模板中的简单名称
    var s1 = "a is $a"

    a = 2
    //模板中的任意表达式
    var s2 = "${s1.replace("is","was")},but now is $a"
    //sample end

    println("s1---->"+s1)

    println("s2---->"+s2)
}