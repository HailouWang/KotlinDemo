package C_ClassAndObject.D_data

// 一、只保存数据的类，数据类
// 语法
data class User(val name:String,val age:Int){

}

// 二、自动继承如下属性成员
// equals、hashCode
// toString 格式："User(name=John,age=42)"
// componentN()函数按照声明顺序对应于所有属性
// copy()

// 三、数据类的要求
// 1、朱构造函数需要只要有一个参数
// 2、朱构造函数的所有参数需要标记为val或者var
// 3、数据类不能是抽象、开放、密封或者内部的

// 四、在类体中声明的属性
// 对于自动生成的函数中，编译器只会用到朱构造函数内部定义的属性。toString、equals、hashCode、copy
// sample start
data class Person(val name:String){
    var age:Int = 0
}
// sample end

// 五、复制

// 六、数据类和解构声明


fun main(args:Array<String>){
    val person1 = Person("John")
    val person2 = Person("John")

    person1.age = 10
    person2.age = 20

    //四、
//    person1 == person2 : true
//    person1 with age 10 : Person(name=John)
//    person2 with age 20 : Person(name=John)
    println("person1 == person2 : ${person1 == person2}")
    println("person1 with age ${person1.age} : ${person1}")
    println("person2 with age ${person2.age} : ${person2}")

    // 五、
    // sample start
    val jack = Person("Jack")
    jack.age = 22;

    val olderJack = jack.copy("OlderJack")

    println("Jack ---> ${jack.age} , "+jack)
    println("Older Jack ---> ${jack.age} , "+olderJack)
    //sample end

    // 六、
    // sample start
    val (name) = jack

    println("$name ---> ")
    //sample end
}









































