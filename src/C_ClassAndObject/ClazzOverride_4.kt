package C_ClassAndObject

//一、方法覆盖。Kotlin需要显示标注可以覆盖的成员和覆盖后的成员
open class BaseForOverride {
    open fun v() {}
    fun nv() {}
}

// 1、DerivedForOverride.v()必须加上 override。
// 2、无论加不加 override ，nv()函数报错，
// 不允许子类存在、定义相同签名的函数

/**
 * Derived:衍生、派生
 */
open class DerivedForOverride : BaseForOverride() {
    final override fun v() {
    }

//    fun nv() {}
}

//3、标注override的成员本身是开放的，即：可以在子类中覆盖
// 如果想禁止子类再次覆盖，使用final关键字
class DerivedForOverride2 : DerivedForOverride {
    constructor(age: String) : super() {

    }
}

//二、属性覆盖
// 1、与覆盖方法类似，额外要求：需要具有兼容的类型
open class Foo {
    open val x: Int
        get() {
            return 0;
        }

    open var y: Int = 2;
}

//2、可以使用var 覆盖val，但反之则不行
class Bar1 : Foo() {
    override var x: Int = 1

//    override val y: Int
//        get() = super.y
//        set(value) {}
}

//三、初始化顺序
//sample start
open class BaseForInitTest(val name: String) {
    init {
        println("初始化 BaseForInitTest")
    }

    open val size: Int =
            name.length.also { println("初始化 参数的长度 $it") }
}

class DerivedForInitTest(
        name: String,
        val lastName: String
) : BaseForInitTest(name.capitalize().also {
    println("子类DerivedForInitTest给父类BaseForInitTest的参数 $it")
}) {
    init {
        println("初始化 DerivedForInitTest")
    }

    override val size: Int = (super.size + lastName.length).also { println("初始化 DerivedForInitTest 参数长度共计：$it") }
}
//sample end

fun main(age: Array<String>) {
    println("使用HelloWorld初始化DerivedForInitTest")
    val d = DerivedForInitTest("hello", "world")
}

// 3.1、备注：
/**
使用HelloWorld初始化DerivedForInitTest
子类DerivedForInitTest给父类BaseForInitTest的参数 Hello
初始化 BaseForInitTest
初始化 参数的长度 5
初始化 DerivedForInitTest
初始化 DerivedForInitTest 参数长度共计：10
*/
//-> 基类构造函数执行时，派生类声明或者覆盖的属性还没开始初始化。
// 故：基类初始化逻辑中，应避免在构造函数、属性初始化器以及init块中使用open成员。

//四、调用超类实现
//4.1、使用super关键字调用其超类的函数与属性访问器
open class FooForSuper{
    open fun f(){
        println("FooForSuper f()")
    }

    open val x:Int get() = 1
}

class BarForSuper : FooForSuper() {
    override fun f(){
        super.f()
        println("BarForSuper f()")
    }

    override val x:Int get() = super.x + 1
}

//4.2、内部类中访问外部类的超类，可以通过外部类名限定的super来实现。super@outer
//sample start
class BarForOuter() : FooForSuper() {
    override fun f() {
        super.f()
    }

    inner class Baz {
        fun g(){
            super@BarForOuter.f() //调用 FooForSuper实现的f()
            super@BarForOuter.x //使用FooForSuper 实现的 x

            f()
            BarForOuter().f()
        }
    }
}

// 五、覆盖规则
// 如果一个类从他的直接超类继承相同成员的多个实现，它必须覆盖这个成员的实现，
// 并提供自己的实现，来消除歧义。可以使用super<超类>来标识哪个实现。
//sample start
open class A{
    open fun f(){
        println("A")
    }

    fun a(){
        println("a")
    }
}

interface B{
    fun f(){
        println("B")
    }

    fun b(){
        println("b")
    }
}

class C() : A(),B{
    //编辑器要求覆盖f()
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}
//sample end

// 六、抽象类
//1、类和其中的某些成员可以声明为abstract，不需要使用open来标注一个抽象类以及抽象函数
//sample start
open class BaseForAbstract{
    open fun f(){}
}

abstract class DerivedForAbstract : BaseForAbstract(){
    override abstract fun f()
}
//sample end












