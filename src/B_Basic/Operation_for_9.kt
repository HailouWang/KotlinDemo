package B_Basic

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    //一、For循环使用语法,For循环可以循环遍历任何提供了迭代器的对象。
//    for(item in collection)println(item)

    //循环体也可以是一个代码块
//    for(item :Int in ints){
//        //...
//    }

    //二、For循环遍历数字区间,区间或者数组的for循环，不会创建迭代器，会编译成基于索引的循环
    //sample start
    for (i in 1..3) {
        println(i)
    }

    for (i in 6 downTo 0 step 2) {
        println("6 downTo 0 step 2 --> $i")
    }
    //sample end

    //三、通过索引遍历数组或者集合
    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println("array $i ----> " + array[i])
    }

    //四、使用withIndex来进行For循环
    for ((index, value) in array.withIndex()) {
        println("the element at $index is $value")
    }

}