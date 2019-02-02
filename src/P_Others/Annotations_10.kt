package P_Others

// 1、注解声明
@Target(
    AnnotationTarget.EXPRESSION,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER
)
@Retention(AnnotationRetention.SOURCE)
annotation class Fancy

annotation class Inject

// 2、注解类
@Fancy
class Foo1 {
    @Fancy
    fun baz(@Fancy foo: Int): Int {
        return (@Fancy 1)
    }
}

// 3、注解构造
class Foo2 @Inject constructor(dependency: MyDependency) {}

// 4、注解属性
class Foo {
    var x: MyDependency? = null
        @Inject set
}

class MyDependency {}

fun main() {
    // 2、
}