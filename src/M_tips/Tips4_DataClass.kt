package M_tips

import C_ClassAndObject.usage

// 数据类自动生成 set、get方法
data class User(val name: String, val age: Int)

fun main(args: Array<String>) {
    val user = User("张三", 19)

    println("user name : " + user.name + ", age : " + user.age)
}