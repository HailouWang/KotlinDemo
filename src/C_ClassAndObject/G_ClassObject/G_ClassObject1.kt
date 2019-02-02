package C_ClassAndObject.G_ClassObject

import C_ClassAndObject.E_InnerClass.MouseAdapter

// 一、目标：创建一个对某个类做了轻微改动的类对象
// Java ：匿名内部类
// Kotlin：对象表达式、对象声明

// sample start
// 匿名类的对象
//window.addMouseListener(object: MouseAdapter(){
//    override fun mouseClick() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun mouseEnter() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//})

// 多个超类型，可以跟上多个参数
open class G_ClassObjectA(x:Int){
    public open val y:Int = x
}

interface G_ClassObjectB{

}

val ab:G_ClassObjectA = object :G_ClassObjectA(1),G_ClassObjectB{

}

// 如果仅需一个对象，并不需要超类型，可以简写

fun foo(){
    val adHoc = object {
        var x:Int = 0
        var y:Int = 1
    }
    println(adHoc.x+adHoc.y)
}

// sample end

// 二、匿名对象作为公有函数的返回类型，那么返回类型是匿名类型的父类型
// 私有函数无此问题

class G_Class{
    // 私有函数，所以其类型是匿名对象的类型
    private fun foo() = object {
        val x:String = "x"
    }

    // 公有函数，所以其返回类型是Any
    fun publicFoo() = object {
        val x:String = "y"
    }

    fun bar(){
        val x1 = foo().x
        // 错误，未能解析到引用的x
//        val x2 = publicFoo().x
    }
}
// sample end

// 三、对象表达式 作用域
//sample start
fun countClicks(){
    var clickedCount = 0
    var enterCount = 0


//window.addMouseListener(object: MouseAdapter(){
//    override fun mouseClick() {
        clickedCount ++
//    }
//
//    override fun mouseEnter() {
        enterCount ++
//    }
//
//})
}

// 对象声明
// 使用object关键字，不能用于变量的右边,可以直接引用且是线程安全的
// sample start
object G_ClassObjectVarObj{
    fun registerDataListener(){

    }
}

// 可以有超类型
object DefaultListener : MouseAdapter(){
    override fun mouseClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mouseEnter() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

// sample end

// 四、伴生对象，关键字 companion,可以省略
// sample start
class MyClass{
    companion object Factory {
        fun create():MyClass = MyClass()
    }
}

// 调用 ： 伴生对象的成员，可通过类名所谓限制符调用
val instance = MyClass.create()

// 还可以实现接口
interface Factory<T>{

}

class G_MyClassFactory{
    companion object :Factory<MyClass>{

    }
}

// 对象表达式 是在使用它们的地方初始化的
// 对象声明第一次访问时，延迟初始化的
// 伴生对象是在类加载解析时，初始化的，和java 静态初始化器一样。


//sample end


fun main(args:Array<String>){
    G_ClassObjectVarObj.registerDataListener()

    DefaultListener.mouseClick()
}



































