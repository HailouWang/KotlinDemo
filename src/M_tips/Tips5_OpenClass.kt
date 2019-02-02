package M_tips

open class Base1 {

}

class Base {

}

class Derived1 : Base1()

// 1、Kotlin Class 默认是final的，不允许继承。如需扩展，需要使用open来修饰
//class Derived2 : Base2 ()
