package P_Others

import java.io.File

// 2、为类提供别名
typealias NodeSet = Set<Network.Node>

typealias FileTable<K> = MutableMap<K, MutableList<File>>

// 3、为函数提供别名
typealias MyHandler = (Int, String, Any) -> Unit

typealias Predicate<T> = (T) -> Boolean

fun main() {
    // 1、类型别名为现有类型提供替代名称。 如果类型名称太长，你可以另外引入较短的名称，并使用新的名称替代原类型名。

    var nodeSet: NodeSet = setOf()

    // 2、
    fun test(t: Predicate<String>): Boolean {
        return t("1")
    }

    var p: Predicate<String> = { it != "" }
    test(p)
}

class Network {
    class Node {}
}