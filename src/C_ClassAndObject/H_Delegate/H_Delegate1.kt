package C_ClassAndObject.H_Delegate

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// 一、类委托
// sample start
interface Base{
    fun print()
}

class BaseImpl(val x:Int) : Base{
    override fun print() {
        print(x)
    }

}

// by 表示 会将b在H_Delegate1_Derived内部存储，并转发给b的所有的Base方法
// 2018年07月25日20:28:06 ： 初步理解为，将Base的所有方法委托给H_Delegate1_Derived
class H_Delegate1_Derived(b:Base) : Base by b

class H_Delegate1_Derived2(b:Base) : Base by b{
    override fun print() {
        print("abc")
    }
}
// sample end


// 二、委托属性
// 语法 val/bar <属性名> : <类型> by <表达式>
// 延迟委托、可观察属性、把多个属性储存在一个映射中

// sample start
class H_Delegate1_Example{
    var p : String by MyDelegate()
}

class MyDelegate{
    operator fun getValue(thisRef:Any?,property:KProperty<*>):String{
        return "$thisRef，谢谢代理属性 '${property.name}'。"
    }

    operator fun setValue(thisref:Any?,property: KProperty<*>,value:String){
        println("$value 在 $thisref 中赋值给 ${property.name} 。")
    }
}
// sample end

// 三、标准委托之延迟属性Lazy：
// 接受一个lambda并返回一个Lazy<T>实例的函数，第一次调用get返回已传递给lazy的lambda表达式
// 并记录结果，后续再次调用get，，只是返回记录的结果。

// sample start
val lazyValue : String by lazy {
    println("computed!")
    "Hello"
}
// sample end

// 四、标准委托之可观察Observable
// sample start
class User{
    var name:String by Delegates.observable("<no name>"){
        property, oldValue, newValue -> println("$property , $oldValue -> $newValue")
    }
}
// sample end

// 五、把属性储存在映射中
// sample start
class MyUser(val map:Map<String,Any?>){
    val name:String by map
    val age:Int by map
    val value:String by map
}
// sample end

fun main(args:Array<String>){
    // 类委托
    val b = BaseImpl(10)
    H_Delegate1_Derived(b).print()//print 10

    H_Delegate1_Derived2(b).print()// print abc_

    println()

    // 属性委托
    val e = H_Delegate1_Example()
    println(e.p)

    e.p = "777"

    // Lazy属性
    println(lazyValue)
    println(lazyValue)

    // Delegates.observable
    val user = User()
    user.name = "first"
    user.name = "second"

    // 把属性存储在映射中
    val myUser = MyUser(mapOf(
            "name" to "John Doe",
            "age" to 23,
            "value" to "dddd"
    ))

    println(myUser.name)
    println(myUser.age)
    println(myUser.value)
}




















