package M_tips

// 在Java 如下方法是无法编译通过的
// 在Kotlin中，有个名词叫做：变量 - 名称遮蔽   Name shadowing
fun main(args: Array<String>) {
    whatPrintf(1)
}

fun whatPrintf(num: Int) {
//    num = 4; 在Kotlin中，这里会编译失败，因为参数num是val，常量不允许更改
    // 但可以新定义num来实现自定义
    val num = 2
    if (num > 0) {
        val num = 3
    }
    print("num is : $num")
}