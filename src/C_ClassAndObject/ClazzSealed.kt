package C_ClassAndObject

/**
 * 密封类表示受限的类继承结构，一定意义上是枚举类的扩展。枚举类只有一个实例，密封类可以有多个实例
 * 1、密封类的子类必须在密封类自身相同的文件内
 * 2、密封类不允许存在parivate的构造
 */
sealed class ClazzSealed {

}

data class Const(val num: Double) : ClazzSealed()
data class Sum(val a: Int, val b: Int) : ClazzSealed()
object NotANumber : ClazzSealed()

fun main(args: Array<String>) {
    // 3、密封类不能够实例化
//    var expr:ClazzSealed = ClazzSealed()

    var expr: ClazzSealed = Const(1.0)
    when (expr) {
        is Const -> expr.num
        is Sum -> expr.a + expr.b
        NotANumber -> Double.NaN
    }
}