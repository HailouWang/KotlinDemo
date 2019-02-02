package A

fun main(args: Array<String>) {
    //一、使用while循环，使用角标控制显示
    //sample start
    var items = listOf("apple", "banana")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
    //sample end
}