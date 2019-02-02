package P_Others

import java.lang.IllegalArgumentException

fun main() {
    // 1、代码格式
    /**
     *
    try {
    // 一些代码
    }
    catch (e: SomeException) {
    // 处理程序
    }
    finally {
    // 可选的 finally 块
    }
     */

    // 2、受检异常和非受检异常
    // 受检异常的特点在于它强制要求开发人员在代码中进行显式的声明和捕获，否则就会产生编译错误。这种限制从好的方面来说，可以防止开发人员意外地忽略某些出错的情况，因为编译器不允许出现未被处理的受检异常；
    // 从不好的方面来说，受检异常对程序中的设计提出了更高的要求。不恰当地使用受检异常，会使代码中充斥着大量没有实际作用、只是为了通过编译而添加的代码。而非受检异常的特点是，如果不捕获异常，不会产生编译错误，异常会在运行时刻才被抛出。
    //非受检异常的好处是可以去掉一些不需要的异常处理代码，而不好之处是开发人员可能忽略某些应该处理的异常。一个典型的例子是把字符串转换成数字时会发生java.lang.NumberFormatException异常，忽略该异常可能导致一个错误的输入就造成整个程序退出。

    // 3、Nothing类型
    fun fail(message: String): Nothing {
        throw IllegalArgumentException(message)
    }

    var a: String? = null;
    val s = a ?: fail("Name Required")
}