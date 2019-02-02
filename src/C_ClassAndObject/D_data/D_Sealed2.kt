package C_ClassAndObject.D_data

//一、密封类是受限的类继承结构，一定意义上是枚举类的拓展
sealed class Expr

data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

// 二、一个密封类是自身抽象的，不能直接实例化，并可以有抽象成员

// 三、密封类不允许有非private构造函数，构造函数默认为private

// 四、密封类的好处在于定义的类型可控，使用when表达式时，不再需要else

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
}