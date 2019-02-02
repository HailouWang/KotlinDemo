package P_Others

/**
 * @author HailouWang
 */
fun main() {
    // 1、空检查,?. 和 ?:
    var b: String? = null

    var length = b?.length ?: 0

    // 2、非空断言操作符：!!,非空断言运算符（!!）将任何值转换为非空类型，若该值为空则抛出异常。
    try {
        var bValue = b!!
        println("b --> " + bValue)
    } catch (e: KotlinNullPointerException) {
        e.printStackTrace()
    }

    // 3、安全的类型转换：如果对象不是目标类型，那么常规类型转换可能会导致 ClassCastException。 另一个选择是使用安全的类型转换，如果尝试转换不成功则返回 null
    val aInt: Int? = b as? Int
    println("aInt --> " + aInt)

    // 4、从可空集合中，得到非空集合
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()

    println("intList --> " + intList)
}