package C_ClassAndObject

//心得：
//1、类初始化必须使用主构造函数，次构造函数类似主构造的重载，想要实例化，必须委托
//2、无论如何，让父类找到相应的实例化函数，要么主构造函数、要么次构造函数

//一、Kotlin中，共同超类 Any，默认超类
//sample start
class ClazzExtends_3_1 //从Any隐式继承
//sample end

//二、显式继承：把需要继承的类放到类头冒号之后。
//注意1：Kotlin中所有类都是final，open关键字与final相反，表示允许继承。
// Effective Java 17条：要么为继承而设计，并提供文档说明。要么禁止继承。
//注意2：如果派生类有主构造函数，那么父类可以使用主构造函数来实例化。
//sample start
open class Base(p: Int) {
    //直接委托给主构造函数
    constructor(p: Int, name: String) : this(p) {

    }

    //委托给其他次构造函数
    constructor(age: Int, p: Int, name: String) : this(p, name) {

    }
}

class Derived(p: Int) : Base(p) {

}
//sample end

//如果类没有主构造函数，那么每个次构造函数，都必须使用super关键字初始化基类型，
// 或委托给另一个构造函数。
// 此时，不同的次构造函数，可以调用父类不同的构造函数
//sample start

open class BaseEmpty {

}

class myBase : Base {
    //无主构造，基类型无法构造
    constructor(index: Int, p: Int) : super(p) {

    }

    //无构造函数，基类型无法实例化，委托给另一次构造函数，完成基类型的实例化
    constructor(index: Int, p: Int, name: String) : this(index, p) {

    }

}

class myBase1 : BaseEmpty {
    //无主构造，基类型无法构造
    constructor(index: Int, p: Int) : super() {

    }

    //无主构造，基类型无法构造
    constructor(index: Int) {

    }
}


















