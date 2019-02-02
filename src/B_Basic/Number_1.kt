package B_Basic

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    //一、内置基本类型
    // Double(64)
    // Float(32)
    // Long(64)
    // Int(32)
    // Short(16)
    // Byte(8)

    // 二、数字进制
    //十进制 123，Long类型用大写的L标记：123L
    //十六进制：0x0F
    //二进制：0b00001011
    //备注：不支持八进制

    //三、数字字面值支持下划线
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    //四、数字装箱后，没有保留同一性，但保留了相等性
    val a: Int = 10000
    println(a === a) //输出true

    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) //！！！输出false，同一性消失

    // -----------------------
    println(a == a) //输出true
    println(boxedA == anotherBoxedA) //输出为true

    //五、显式转换,较小的类型并不是较大类型的子类型
    //如下代码会编译错误
//    val x:Int? = 1
//    val b:Long? = x

    //六、每个数字都支持toByte、toShort、toInt、toLong、toFloat、toDouble、toChar
    val tom: Int = 1
    val jerry: Long = tom.toLong()

    println(" tom equals jerry : ${tom.equals(jerry)}") // false

    //七、数字运算，类型会自动从上下文推断出来
    val l = 1L + 3 //Long + Int => Long

    //八、Int 和 Long 的位运算表
    //shl(bits) 有符号左移
    //shr(bits) 有符号右移
    //ushr(bits) 无符号右移
    //and(bits) 位与
    //or(bits) 位或
    //xor(bits) 位异或
    //inv() 位非
    val x = (1 shl 2) and 0x000f_f000

    //八、浮点数比较 float 、double
    //相等性 a == b 、 a !=b
    //比较运算符 a < b 、 a > b、a<=b、a>=b
    //区间实例以及区间检测： a..b 、 x in a..b 、 x!in a..b
    //当操作符并非静态类型float、double，那么结果可能为NaN、正无穷大
}