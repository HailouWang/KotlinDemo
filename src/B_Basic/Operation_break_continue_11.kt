package B_Basic

/**
 * @author HailouWang
 */
fun main(args:Array<String>){
    //一、Kotlin有三种结构化跳转表达式
    //return 默认从最直接包围它的函数或者匿名函数返回
    //break 终止最直接包围它的循环
    //continue 继续下一次最直接包围它的循环

    //二、标签
    //在kotlin中，任何表达式都可以用标签label来标记。格式：
    //标识符+@，例如：abc@、fooBar@
    loop@ for(i in 1..100){
        if(i == 50)break@loop
        println("loop ---> $i")
    }

    //三、return以及标签限制的return。
    //return ：从函数中返回
    //return label：从lambda表达式中返回，隐式Label与lambda表达式同名
    //sample start
    fun foo(){
        listOf<Int>(1,2,3,4,5).forEach {
            if(it == 3)return
            println("foo --> "+it)
        }
        println("this point is unreachable...")
    }
    //sample end
    foo()

    //sample start
    fun fooWihtLabel(){
        listOf<Int>(6,7,8,9,10).forEach each@{
            if(it == 8)return@each
            println("fooWithLabel --> $it")
        }

        listOf(11,22,33,44,55).forEach {
            if(it == 33)return@forEach
            println("fooWithLabel --> $it")
        }

        listOf(66,77,88,99,100).forEach(fun(value:Int) {
            if(value == 99) return //局部返回到匿名函数的调用者，即：forEach循环
            println("fooWithFun ---> $value")
        })

        println(" done with explicit label")
    }

    fooWihtLabel()
}