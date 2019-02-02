package A

fun main(args: Array<String>) {
    var items = listOf("apple", "banana")
    //一、使用集合进行遍历
    //sample start
    for (item in items) {
        println(item)
    }
    //sample end

    //二、使用in运算符来判断集合内是否包含某实例
    //sample start
    when {
        "orange" in items -> println("🍊")
        "apple" in items -> println("🍎")
    }
    //sample end

    //三、使用lambda表达式进行过滤filter和映射map集合
    //sample start
    items
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
    //sample end
}