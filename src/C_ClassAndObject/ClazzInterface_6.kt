package C_ClassAndObject

//一、Kotlin接口与Java 8类似，既可包含抽象方法声明也包含实现。
// 备注：接口无法保存状态等成员属性。使用关键字interface定义
//sample start
interface MyInterface {
    fun bar()
    fun foo() {

    }
}
//sample end

//二、实现接口，一个类或者对象可以实现一个或者多个接口
//sample start
class Child : MyInterface {
    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
//sample end

//三、接口中的属性
//1、属性要么是抽象的，要么提供访问器
//2、不能有幕后属性字段
//sample start
interface MyInterfaceForVar {
    val prop: String

    val propertyWithImplementation: String
        get() = "foo"

    val propertyWithImplementedError: String get() = prop

    fun foo() {
        println(prop)
    }
}
//sample end

class ChildForVar : MyInterfaceForVar {
    override val prop: String = "29"
}

//四、覆盖冲突
//方法没有方法体，默认为抽象方法
//我们从InterfaceA、InterfaceB中派生多个接口，出现方法冲突，需要制定如何实现。
//sample start
interface InterfaceA {
    fun foo() {
        println("A")
    }

    //方法没有方法体，默认为抽象方法
    fun bar()
}

interface InterfaceB {
    fun foo() {
        println("A")
    }

    fun bar() {
        println("B")
    }
}

class ClassC : InterfaceA {
    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        println("Class C bar() ")
    }

}

class ClassD : InterfaceA, InterfaceB {
    override fun foo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        super<InterfaceA>.foo()
        super<InterfaceB>.bar()
    }

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //不存在super<InterfaceA>.bar()，InterfaceA中bar是抽象方法
//        super<InterfaceA>.bar()
        super<InterfaceB>.bar()
    }

}
//sample end































