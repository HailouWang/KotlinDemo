package P_Others

// 解构声明：将对象解构成很多变量会很方便
fun main(args: Array<String>) {
    var person = Person("李明", 23, "北京市朝阳区")

    // 1、解构
    var (name, age) = person

    // 2、我们可以直接使用解构的变量
    println(" person name : " + name)
    println(" person age : " + age)

    // 3、解构声明等同于如下代码
    name = person.component1()
    age = person.component2()

    // 4、componentN 函数
    var map = mapOf<String, Int>("a" to 1, "b" to 2, "c" to 5)
    var list = listOf<String>("a", "b", "c", "d", "e", "f", "g", "h")
    list.component1()
    list.component2()
    list.component3()
    list.component4()
    list.component5()
    var item6 = list.component6() // 需要单独声明、创建
    println("item6 : " + item6)
//    list.component7() // 出错、出错、出错

    // 5、解构在for中的使用
    for ((a, b) in map) {
        println("a : " + a + ",b : " + b)
    }

    // 6、从函数中返回两个变量
    fun findAPerson(): Person {
        return Person("zhangsan", 26, "shandong")
    }

    val (myName, myAge) = findAPerson()
    println(" myName : " + myName + ",myAge: " + myAge)

    // 7、使用 _下划线跳过未使用的变量
    val (_, selfAge) = findAPerson()
    println("只获得了年龄： " + selfAge)

    // 8、lambda表达式中使用解构
    var newMap = map.mapValues { (_, value) -> "$value!" }
    println(" new Map is :" + newMap)
}

private fun <E> List<E>.component6(): E {
    return get(5)
}

// 使用 operator 修饰，允许在解构声明中使用它们
//public inline operator fun <T> List<T>.component7(): T {
//    return get(6)
//}

data class Person(val name: String, val age: Int, val address: String)