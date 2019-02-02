package B_Basic

/**
 * @author HailouWang
 */
fun main(args:Array<String>){
    //一、字符用Char表示，它们不能直接当做数字
//    val c:Char
//    if(c == 1) //本行代码编译错误

    //二、字符字面值用单引号括起来'1',特殊字符使用反斜杠转义
    val c1:Char = '1'
    val c2 = '2'

    //三、字符转换成数字
    //sample start
    val number1 = c1.toInt() - '0'.toInt();
    println("$c1 parse to number is : $number1")
    //sample end

    //四、字符可能为空引用，装箱操作不会保留同一性
    val c3:Char?
}
