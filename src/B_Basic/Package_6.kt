package B_Basic

/**
 * @author HailouWang
 */
fun main(args:Array<String>){
    //一、源文件通常内容
    //sample start

//    package foo.bar
//
//    fun baz(){}
//
//    class Goo{}

    //sample end

    //baz()   --> foo.bar.baz
    //Goo     --> foo.bar.Goo

    //二、默认导入,以下多个包会默认导入到Kotlin文件中
    //kotlin.*
    //kotlin.annotation.*
    //kotlin.collections.*
    //kotlin.comparisons.*
    //kotlin.io.*
    //kotlin.ranges.*
    //kotlin.sequences.*
    //kotlin.text.*

    //JVM
        //java.lang.*
        //kotlin.jvm.*
    //JS
        //kotlin.js.*

    //三、导入  特定
    //导入一个单独的名字
    //import foo.Bar

    //导入一个作用域下的所有内容
//    import foo.*

    //如果出现名字冲突，可以使用 as关键字在本地重命名冲突来消除歧义
    //import foo.Bar
    //import bar.Bar as bBar

    //四、import不仅可以导入类，也可以导入其他声明
    //顶层函数及属性
    //对象中声明的函数和属性
    //枚举常量
}