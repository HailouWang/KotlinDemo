package P_Others

fun main() {
    // 1、类引用
    val kclass = MyClass::class
    val jclass = MyClass::class.java

    // 2、函数引用
    fun isOdd(x: Int) = x % 2 != 0

    // 3、:: 操作符
    // 们可以很容易地直接调用它（isOdd(5)），但是我们也可以将其作为一个函数类型的值，例如将其传给另一个函数。为此，我们使用 :: 操作符：
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))

    // 4、
    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        return { x -> f(g(x)) }
    }
    fun length(s: String) = s.length

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")

    println(strings.filter(oddLength))

}

class MyClass {}