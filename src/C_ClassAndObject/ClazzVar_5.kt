package C_ClassAndObject

import jdk.nashorn.internal.ir.annotations.Ignore


//一、Kotlin可以有属性，使用var声明为可变，val只读
public class Address{
    var name: String = ""
}

//二、使用属性，只要用名称引用即可。
fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = "good"
    return result
}

//三、声明属性-完整语法
// 3.1、初始器property_initializer、getter和setter都是可选的。
// 属性类型可以通过getter返回值中ong推断出来。
//var <propertyName>[:<PropertyType>][=<property_initializer>]
//        [<getter>]
//        [<setter>]
//sample start
//var allByDefault:Int? //错误，需要显式初始化器，隐含默认getter和setter
var initialized = 1 //类型Int、默认getter和setter

//var isEmptyAnyType get() = true
//sample end

// 3.2、只读属性和可变属性，存在两个方面的不同：
// 3.2.1、只读使用val，可变使用var
// 3.2.2、只读不允许setter
//sample start
//val simple: Int? //必须在构造函数中初始化
val inferredType = 1 //类型 Int、默认getter

//自定义get
val isEmpty: Boolean get() = false

//自定义set
var stringRepresentation: String
    get() {
        println("stringRepresentation ---> get")
        return "内容为="
    }
    set(value) {
        println("stringRepresentation set ----> value :$value")
    }
//sample end

// 4、修改访问器的可见性或者注解， 但不希望修改器默认实现.
//sample start
var setterVisibility:String = "abc"
private set //此 setter是私有，并且默认实现

var setterWithAnnotation:Any? = null
@Ignore set //用Inject注解setter
//sample end

// 5、幕后属性 backing property
//sample start
private var _table:Map<String,Int>? = null

//var table:Map<String,Int> get() {
//    if(_table == null){
//        _table = HashMap()//类型已推断出
//    }
//    return _table ?: throw AssertionError("Set to null by another thread")
//}
//sample end

// 6、编译器常量
//可以使用const修饰符标记编译器常量，特征如下：
// 位与顶层或者是Object的一个成员
// 用String或者原生类型来初始化
// 没有自定义的getter
//sample start
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED)fun foo(){

}
//sample edn

// 7、延迟初始化属性与变量
// 检测延迟属性是否初始化，使用.isInitialized
//sample start
public class MyTest{
    public lateinit var subject:Address

    @SetUp fun setup(){
        subject = Address()
    }

    fun test(){
        subject.name
    }

    annotation class SetUp
}

fun main(args:Array<String>){
    stringRepresentation = "立正、向左看、稍息"
    println("输出stringRepresentation --》 $stringRepresentation")

    setterVisibility = "def"

//    var myTest = MyTest()
//    if(myTest::subject.isInitialized){
//
//    }
}



