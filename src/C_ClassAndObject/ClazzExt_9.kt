package C_ClassAndObject

//Kotlin支持扩展函数和拓展属性
// 一、扩展函数
// 语法：需要用一个接受者类型也就是被扩展的类型来作为前缀
//sample start
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}
//sample end

// 二、拓展是静态解析的
// 拓展并不能真正修改他们所扩展的类，通过定义一个扩展，并没有在类中插入新成员。

//sample start
open class C_ext

class D_ext : C_ext()

fun C_ext.foo() = "C_ext"

fun D_ext.foo() = "D"

fun printFoo(c: C_ext) {
    println("---> ${c.foo()}")
}
//sample end

// 三、拓展函数与成员函数相同 ，取成员函数
//sample start
class C_ext1 {
    fun foo() {
        println("成员函数")
    }
}

fun C_ext1.foo() {
    println("拓展部分")
}
//sample end

// 四、可空接收者
//sample start
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，this自动转换未非空类型，所以下面的toString解析为Any类的成员函数
    return toString()
}
//sample end

// 五、扩展属性
// 扩展没有实际的代码插入类中，故：扩展属性对幕后字段是无效的。
//sample start
val <T> List<T>.lastIndex: Int
    get() = 3;
//sample end

// 六、伴生对象的扩展
// 伴生对象，需要使用类名作为限定符去调用他们
//sample start
class MyClass {
    companion object {

    }
}

fun MyClass.Companion.foo() {

}

//sample end

// 七、扩展的作用域
// sample start
fun usage(c_ext: C_ext1) {
    c_ext.foo()
}
// sample end

// 八、扩展声明为成员
//
// 对于分发接收者和扩展接收者，成员命名冲突，扩展接收者优先，可以使用this调用其他分发接收者的方法
// sample start
class D_Ext_2 {
    //拓展接收者
    fun bar() {

    }
}

class C_EXT_2 {
    //分发接收者
    fun baz() {

    }

    //在C_EXT内部为D_EXT声明扩展
    fun D_Ext_2.foo() {//在其内部，可以无须通过访问限定符访问baz或者bar
        bar()//调用 D_EXT.bar
        baz()//调用C_EXT.baz
    }

    fun caller(d_ext: D_Ext_2) {
        d_ext.foo() //调用扩展函数
    }

    fun callerToString(d_ext: D_Ext_2) {
        toString() //调用D_EXT#toString
        this@C_EXT_2.toString() //调用C_EXT#toString
    }
}

// 九、扩展属性的覆盖问题
// 关于覆盖，对分发接收者是虚拟的，对于扩展接收者是静态的。
// 即：分发接收者是可以覆盖的，扩展接收者静态不可以覆盖
// sample start
open class D_Override {
}

// D_Override中的扩展声明，不会随着继承而继承
class D_Override2 : D_Override() {
}

open class C_Override{
    open fun D_Override.foo(){
        println("D_Override.foo in C_Override")
    }

    open fun D_Override2.foo(){
        println("D_Override2.foo in C_Override")
    }

    fun caller(d_override:D_Override){
        d_override.foo()
    }
}

class C_Override1 : C_Override(){
    override fun D_Override.foo() {
        println("D_Override.foo in C_Override1")
    }

    override fun D_Override2.foo() {
        println("D_Overide2.foo in C_Override1")
    }
}
// sample end

// 十、拓展动机
// 我们不想在方法内实现某些工具方法，这个时候拓展就帮到了我们


fun main(args: Array<String>) {
    // 一、语法中的'this'对应扩展函数的接收者对象
    val multableList = mutableListOf<Int>(1, 2, 3)

    println("before:" + multableList)

    multableList.swap(0, 2)

    println("after:" + multableList)


    // 二、拓展调用，只取决于参数的声明类型，不重载
    printFoo(D_ext())

    // 三、拓展与成员函数，相同
    println(C_ext1().foo())

    // 五、拓展属性

    // 六、伴生对象的扩展
    MyClass.foo();

    // 九、
    C_Override().caller(D_Override())
    C_Override().caller(D_Override2())

    C_Override1().caller(D_Override())
    C_Override1().caller(D_Override2())
}

















































