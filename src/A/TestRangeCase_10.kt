package A

fun main(args: Array<String>) {
    //一、使用in运算符来检测某个数字是否在指定区间内
    //sample start
    var x = 10;
    var y = 9;
    if (x in 1..y + 1) {
        println("fits in ranges")
    }
    //sample end

    //二、检测某个数字是否在指定区间外
    //sample start
    var list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    //list size is : 3, list indices 0..2, list lastIndex is 2
    println("list size is : ${list.size}" +
            ", list indices ${list.indices}" +
            ", list lastIndex is ${list.lastIndex}")

    if (list.size !in list.indices) {
        println("list size out of valid list indices range too")
    }
    //sample end

    //三、区间迭代，迭代的意思是轮循、遍历
    //sample start
    for (x in 1..5) {
        print(x)
    }
    //sample end

    println("------->")

    //四、数列迭代
    //sample start
    for (x in 1..10 step 2) {
        print(x)
    }
    println("\n x -----> $x")
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
    //sample end

    //五、until关键字
    for(i in 1 until 100 step 2){
        println("x --> $x")
    }
}