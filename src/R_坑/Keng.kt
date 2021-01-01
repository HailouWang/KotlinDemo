package R_坑

import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType
import kotlin.test.todo

class Keng {

    var nullableString: String? = null

    val CONST_LAZY_KEY: String by lazy { "lazy_const_value" }

    fun testNullableString() {
//        if (nullableString != null) {
//            var nullableStringLength = nullableString.length
//        }

        var nullableStringLength = nullableString?.length
    }

//    override fun onDialogCreate(savedInstanceState: Any?) {
//        //todo code
//    }

    fun testTodo(): Unit {
        TODO()
    }

    /**
     * Kotlin 入参是常量
     */
    fun print(a: Int = 1, b: String = "") {
        // a = 10; // 错误：Val cannot be reassigned!!!
    }

    fun staticMethodAndVar() {

    }

    fun testAsIs() {
        var obj: Any? = null

        if (obj is String) {// 方法体内的作用域，obj 就是 String
            var length = obj.length
        }

        var text: Any? = null

//        //错误写法1，text不是String或为空时，会报异常
//        var strAble1 = text as String
//
//        //错误写法2，text不是String时，同样会报异常
//        var strAble2 = text as String?

        var strAble = text as? String

        print("testAsIs ---------> ${strAble} ")
    }

    fun testTakeIf() {
        var flag = 0
        var summary = "升旗".takeIf { flag > 1 }
        print("testTakeIf flag=${flag},summary=${summary}")
    }

    fun testLazy() {
        println("lazy start --------")
        println(CONST_LAZY_KEY)
        println("lazy end --------")
    }

    companion object {
        val EMPTY = ""

        fun isEmpty(string: String = EMPTY) {
            //todo code
        }

        @JvmField
        val FULL_NUMBER = "1234567890"

        @JvmStatic
        fun isNumber(string: String = FULL_NUMBER) {
            //todo code
        }

        @JvmOverloads
        @JvmStatic
        fun isNumberWithOverLoads(string: String = FULL_NUMBER) {
            //todo code
        }
    }

}

fun main(args: Array<String>) {

    var keng: Keng = Keng()
//
//    // Kotlin 访问 Kotlin 中的常量
//    Keng.EMPTY
//    // Kotlin 访问 Kotlin 中的静态方法
//    Keng.isEmpty()
//
//    // Kotlin 访问 Kotlin 中带有 JvmField 修饰的常量
//    Keng.FULL_NUMBER
//
//    keng.testNullableString()

//    keng.testTodo()

//    keng.testAsIs()

//    keng.testTakeIf()

    keng.testLazy()
}