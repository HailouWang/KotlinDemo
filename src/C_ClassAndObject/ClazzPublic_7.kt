package C_ClassAndObject

// 一、可见性修饰符
// setter等都可以有可见性修饰符，getter与属性有着相同的修饰符
// private、protected、internal、public，默认是public
// private：声明它的文件内可见
// internal：相同的模块内可见
// protected 不适用于顶层声明
//sample start
private fun ClazzPublic_7_foo(){}

public var bar:Int = 5 //该属性随处可见
private set //setter只在本类中可见

internal var baz = 6  //相同模块内可见
//sample end

// 二、对于覆盖方法，protected成员如果没有指定其可见性，该成员还是protected
//sample start
open class Outer{
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 //默认public

    protected class Nested{
        public val e: Int = 5
    }
}

class Subclass :Outer(){
    // a 不可见
    // b、c、d可见
    //Nested和e可见

    override val b = 5
}

class Unrelated(o:Outer){
    // o.a 不可见
    // o.c o.d可见，相同模块
    //Outer.Nested不可见，Nested.e不可见
}
//sample end

//三、构造函数
//要指定一个主构造函数的可见性，使用如下语法
class ClazzPublic_7_C private constructor(a:Int){

}

//这里的构造函数是私有的，默认情况下 构造函数是public