package C_ClassAndObject

//一、类使用 class 声明，类包含：类名、类头(类型参数、主构造函数)
//备注：没有类体，可以省略花括号
//sample start
class Clazz_1 {

}

class Empty
//sample end

//二、构造函数
//Kotlin中，关于构造函数：一个主构造函数、多个次构造函数。
//备注1：主构造函数是类头的一部分，跟在类名后。
//备注2：主构造函数可以省略constructor关键字，前提是无注解或者可见修饰符
//sample start
class Person constructor(firstName: String) {

}

class Person1(firstName: String) {

}

//class Person3 public @Inject constructor(firstName: String) {
//
//}
//sample end

//三、初始化顺序
//主构造函数不包含任何代码，初始化代码可以放到init关键字的代码块中。
//注意1：【初始化代码 = 初始化块 + 属性声明】可以按照它们出现在类体中的顺序来执行，属性也是会执行的。
//注意2：主构造的参数可以在初始化块中使用，也可以属性初始化器中使用
//sample start
class InitOrderDemo(name: String) {
    val firstproperty = "首次 属性名称：$name".also(::println)

    init {
        println("首次 初始化代码块 打印 ： $name")
    }

    val secondProperty = "第二次 属性 ： ${name.length} ".also(::println)

    init {
        println("第二次 初始化代码块 打印： ${name.length}")
    }
}
//sample end

//fun main(args: Array<String>) {
//    InitOrderDemo("hello")
//}

//四、次构造函数
//4.1、次构造函数，在类体中，使用constructor来声明
//sample start
class Person4 {
    constructor(parent: Person1) {
        parent.toString()
    }
}
//sample end

//4.2、如果类存在主构造函数，那么次构造函数需要委托。委托：直接委托、间接委托。
//直接委托：使用this关键字，调用具体的主构造函数
//间接委托：通过别的次构造函数委托。
//sample start
class Person5(name: String) {
    constructor(name: String, parent: Person4) : this(name) {
        parent.toString()
    }
}
//sample end

//4.3、主、次构造函数与初始化代码块
//无论主构造函数是否存在，初始化代码块，都会成为主构造函数的一部分。
//故：初始化代码块会在次构造函数体前执行
//sample start
class Constructors {
    val firstproperty = "aaaa 首次，无主构造函数".also(::println)

    init {
        println("aaaa Init block")
    }

    var secondVar = "aaaa 再次，无主构造函数".also(::println)

    constructor(i: Int) {
        println("aaaa Constructor")
    }

    init {
        println("aaaa 第二次 初始化代码块 打印： ${firstproperty.length}")
    }

    var thirdVar = "三次，无主构造函数".also(::println)
}

fun main(args: Array<String>) {
    InitOrderDemo(initString())
    println("<------------------------->")
    Constructors(1)
}

fun initString(): String {
    print("Clazz_1 initString")
    return "Clazz_1 initString"
}

//4.4、非抽象类无论有无声明主、次构造函数，其都有一个无参主构造函数，可见性为public，可修改可见性
//sample start
class DontCreateMe private constructor() {

}
//sample end
































