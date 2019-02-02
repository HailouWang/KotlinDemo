package B_Basic

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    //一、数组在Kotlin中，使用Array类来标识，定义了get、set（get、set = []）函数和size属性
    //sample start
    val array1 = Array(5, { i: Int -> (i * i).toString() })
    val array2 = arrayOf(1, 2, 3)
    val array3 = arrayOfNulls<Int>(3)
    val array4 = arrayOf(1, 2, "3")

    //二、[]运算符代表Array中的get和set函数
    println("array1[0] is " + array1[0].toString())
    array3[0] = 3
    println("array3[0] is " + array3[0])

    //三、Kotlin中Array invariant特性
    //如下代码编译错误，无法将Array<String>赋值给Array<Any>
//    val array4:Any
//    val array5:String = array4;

    //四、无装箱开销的原生类型数组，无需类型转换
    val array6: ByteArray = byteArrayOf(127, -128, 98)
    array6[0] = (array6[1] + array6[2]).toByte()

    //五、返回类型Unit的方法的Builder风格
    fun arrayOfMinusOnes(size:Int):IntArray{
        return IntArray(size).apply { fill(-1) }
    }


}