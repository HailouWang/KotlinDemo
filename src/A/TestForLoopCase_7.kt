package A;

fun main(args: Array<String>) {
    var items = listOf("apple", "banana")
    //一、for循环，item in items中的item随便命名
    //sample start
    for (item in items) {
        println("--->" + item)
    }
    //sample end

    //--------------------------

    //二、for循环，使用index角标
    //sample start
    for(index in items.indices){
        println("item at $index is ${items[index]}")
    }
    //sample end
}
