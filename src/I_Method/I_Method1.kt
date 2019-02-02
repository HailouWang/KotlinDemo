package I_Method

// 一、函数声明
fun double(x:Int) :Int{
    return 2*x
}

// 二、函数调用

// 三、默认参数值
// 函数可以有默认值，省略相应的参数可以使用默认值

// 四、覆盖方法使用与基类相同的默认参数值，当覆盖默认参数值时，必须省略默认参数值
//sample start
open class A{
    open fun foo(i:Int = 10){
        println("foo--->"+i)
    }

    open fun test(i:Int = 10){
        println("test--->"+i)
    }

    open fun sample(i:Int = 10,y:Int){
        println("test--->"+i)
    }

    open fun demo(i:Int,y:Int = 5){
        println("test--->"+i)
    }
}

class B :A(){
    override fun foo(i: Int) {
        println(i)

        test()
    }

    // 错误，不能带有默认值
//    override fun test(i: Int = 20) {
//        super.test(i)
//    }

    // 错误，必须省略默认参数
//    override fun test(i: Int = 10) {
//        super.test(i)
//    }
}
// sample end

// 五、当一个函数对奥用混用位置参数与命名函数时，所有的位置参数都要放在命名参数之前。

// 六、可以通过 *号将可变数量参数以命名的方式传入
//sample start
class C{
    fun foo(vararg string: String){

    }
}


fun main(args:Array<String>){
    //函数调用
    val result = double(2)

    //四、调用
    B().foo() // 使用默认值，可以不用传递参数来调用函数
    B().sample(y = 20)// 第一个参数使用默认值，第二个参数使用传入值

    // 五、
    B().sample(2,y = 20)
    B().demo(4)
    B().demo(i = 4)
    B().demo(y = 20,i = 4)

    // 六、
    C().foo("a","b","c")
    // arrayOf 返回Array<String>,request String,found Array
    C().foo(*arrayOf("a","b","c"))
}