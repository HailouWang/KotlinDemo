package P_Others

fun main(args: Array<String>) {
    // 1、is、!is操作符
    var obj = null

    if(obj is String){
        println("obj ---> "+obj)
    }

    if(obj !is Int){
        println("obj isnot Int")
    }

    // 2、智能转换
    var c: Any? = null
    if (c is String) {
        println("b length is : " + c.length)
    }

    if (c !is String) {
        return
    }
    // 自动推断出c为String
    c.length

    var d: Any? = null
    if (d !is String || d.length == 3) {

    }

    if (d is String && d.length == 4) {

    }

    when (d) {
        is Int -> println(d)
        is String -> println(d.length + 1)
        else -> println("其他")
    }

    // 3、不安全的转换操作符
    val x1:String = c as String
    // 如果y为空，上面的代码会抛出一个异常，为了避免抛异常，返回一个可空类型。可以使用String？或者 as？
    val x2:String? = c as String?
    // 或者
    val x3:String? = c as? String

    // 4、

}