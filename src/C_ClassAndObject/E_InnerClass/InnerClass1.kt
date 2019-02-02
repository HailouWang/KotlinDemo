package C_ClassAndObject.E_InnerClass

// 一、类可以嵌套在其他类中
//sample start
class Outer{
    class InnerClass1{
        private val bar:Int = 1
        fun foo() = 2
    }
}
//sample end

// 二、类可以使用inner标记，以便能够访问外部类的成员。
// 内部类默认含有一个外部类对象的引用
//sample start
class Outer2{
    private val bar:Int = 1
    inner class Inner{
        //不含有inner，则会无法引用到bar
        fun foo() = bar
    }
}
// sample end

// 三、匿名内部类
//sample start
abstract class MouseAdapter{
    abstract fun mouseClick()
    abstract fun mouseEnter()
}

class InnerWindow{
    fun addMouseListener(adapter: MouseAdapter){
        adapter.mouseClick()
        adapter.mouseEnter()
    }
}
//sample end

fun main(args:ArrayList<String>){
    // 嵌套类
    val demo = Outer.InnerClass1().foo()

    // 内部类,内部类含有Inner，则不能使用Outer2.Inner
    val demo2 = Outer2().Inner().foo()

    // 匿名内部类
    val window = InnerWindow()
    window.addMouseListener(object:MouseAdapter(){
        override fun mouseClick() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun mouseEnter() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    })
}