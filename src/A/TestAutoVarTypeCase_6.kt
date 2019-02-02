package A

/**
 * @author HailouWang
 */
//一、自动类型 转换 is关键字
//sample start
fun getStringLength1(obj: Any): Int? {
    //在检测之前，执行obj.length是错的
    if (obj is String) {
        //执行is类型检测后，在该条件分支内，自动转换成String类型
        return obj.length;
    }
    //在离开条件分子后，obj仍然是Any类型
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String) return null

    //后边obj会自动转换成String
    return obj.length
}

fun getStringLength3(obj: Any): Int? {
    //obj 在&& 之后自动转换成String类型
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}
//sample end


fun main(args: Array<String>) {
    fun printLength(obj: Any) {
//        println("'$obj' String length is ${getStringLength1(obj)
//                ?: "... err,not a string"} ")

        println("'$obj' String length is ${getStringLength2(obj)
                ?: "... err,not a string"} ")
    }

    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}