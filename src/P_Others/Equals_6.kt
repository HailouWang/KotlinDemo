package P_Others

fun main(args: Array<String>) {
    // 结构相等：== 以及 != 来操作
    var a = 3
    var b = 3
    var equals = a?.equals(b) ?: b === null
    println("a equals b : " + equals)

    // 引用相等：===来操作：求值为true
    var veryEquals1 = a === b
    var veryEquals2 = a == b
    println("a very equals b : " + veryEquals1 + ",very equals2:" + veryEquals2)
}
