package A

//一、使用when
//sample start
fun describe(obj: Any): String =
        when (obj) {
            1 -> "one"
            "Hello" -> "你好"
            is Long -> "Long类型"
            !is String -> "Not a String"
            else -> "Unknown"
        }

fun describe1(obj: Any): String {
    when (obj) {
        1 -> return "one"
        "Hello" -> return "您好"
        is Long -> return "Long类型"
        !is String -> "Not a String"
        else -> return "Unknown"
    }
    return ""

    // or
    // return when...
}
//sample end

fun main(args: Array<String>) {
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

    println("-------------------")
    println(describe1(1))
    println(describe1("Hello"))
    println(describe1(1000L))
    println(describe1(2))
    println(describe1("other"))

    // 二、返回when表达式
    fun transform(color:String):Int{
        return when(color){
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }
}