package B_Basic

import A.parseInt

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    //一、when替换了其他语言中的switch操作符
    val x: Any? = 1.toString()
    when (x) {
        1, 3 -> println("x === 1")
        2 -> println("x === 2")
        else -> {
            println("x is neighter 1 nor 2")
        }
    }

    //二、使用说明
    //when将它的菜蔬和所有分支条件顺序比较，直到某个分支满足条件。
    //多个条件使用逗号，分隔
    //when表达式：符合条件的分支的值就是整个表达式的值，必须有else分支，除非包含了编辑器能够检测的所有值
    //when语句：类似if，值是表达式最后一个符合条件的值

    //三、分支条件可以是常量也可以是任意表达式
//    when (x) {
//        parseInt(x) -> println("s encodes x")
//        else -> println("s does not encode x")
//    }

    //四、检测值 在或者不在 一个区间或者集合内
    var validNumvbers = listOf<Int>(10, 20, 30, 40)
    when (x) {
        in 1..10 -> println("x is in the range")
        in validNumvbers -> println("x is valid")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }

    //五、is或者!is检测，由于智能转换，检测后，可以直接访问该类型的方法和属性，而无需额外转换
    when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    //六、如果不提供参数，则所有的分支条件都是简单的Boolean表达式
//    when {
//        x.isOdd() -> println("x is odd")
//        x.isEven() -> println("x is even")
//        else -> println("x is funny")
//    }
}