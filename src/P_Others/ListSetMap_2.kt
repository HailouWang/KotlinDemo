package P_Others

fun main(args: Array<String>) {
    // 1、初始化一个可变的集合
    val list: MutableList<Int> = mutableListOf<Int>(1, 2, 3)
    var set: MutableSet<String> = mutableSetOf<String>("1", "2", "3")
    var map: MutableMap<Int, String> = mutableMapOf<Int, String>(1 to "one", 2 to "two")

    // 2、初始化一个不可变的集合
    val readOnlyList: List<Int> = list
    var readOnlySet: Set<String> = set
    var readOnlyMap: Map<Int, String> = map

    // 如下不能编译通过，只读、不可变的集合，不存在clear方法
//    readOnlyList.clear()
//    readOnlySet.clear()
//    readOnlyMap.clear()

    // 3、初始化一个不可变的集合
    var _items = listOf<String>("1", "2", "3")

    // 4、返回一个集合的快照
    val items1 = _items.toList()

    // 5、List的一些方法
    val items = listOf(1, 2, 3, 4)
    items.first() == 1
    items.last() == 4
    items.filter { it % 2 == 0 } //返回 2、4

    val rwList = mutableListOf(1, 2, 3, 4)
    try {
        val noNulllist = rwList.requireNoNulls()
        println("noNulllist : " + noNulllist)
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }

    val aboveSix = rwList.none { it > 6 }
    println("不含有比6大的元素： " + aboveSix)

    // 6、filter等方法，线程不安全
    items.filter { it > 6 }
}