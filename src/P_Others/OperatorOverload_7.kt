package P_Others

data class Point(val x: Int, val y: Int)

// 1、使用 operator 可以重载操作符
operator fun Point.unaryMinus() = Point(-x, -y)

operator fun Point.inc() = Point(x + 1, y + 1)

var point = Point(10, 20)

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}

fun main() {
    // 2、可以直接调用
    println(-point) //Point(x=-10, y=-20)

    // 3、++,直接调用Point.inc()函数
    println(++point) // Point(x=11, y=21)

    /** 一元操作符重载列表
     * +a	a.unaryPlus()
     * -a	a.unaryMinus()
     * !a	a.not()
     * a++	a.inc() + 见下文
     * a--	a.dec() + 见下文
     */

    // 4、二元操作符
    var counter1 = Counter(1)
    var counter = counter1 + 5
    println(counter)

    /**
     * a + b	a.plus(b)
     * a - b	a.minus(b)
     * a * b	a.times(b)
     * a / b	a.div(b)
     * a % b	a.rem(b)、 a.mod(b) （已弃用）
     * a..b	a.rangeTo(b)
     */

    // 5、in操作符
    /**
     * a in b	b.contains(a)
     * a !in b	!b.contains(a)
     */

    // 6、索引操作符
    /**
     * a[i]	a.get(i)
     * a[i, j]	a.get(i, j)
     * a[i_1, ……, i_n]	a.get(i_1, ……, i_n)
     * a[i] = b	a.set(i, b)
     * a[i, j] = b	a.set(i, j, b)
     * a[i_1, ……, i_n] = b	a.set(i_1, ……, i_n, b)
     */

    // 7、调用操作符
    /**
     * a()	a.invoke()
     * a(i)	a.invoke(i)
     * a(i, j)	a.invoke(i, j)
     * a(i_1, ……, i_n)	a.invoke(i_1, ……, i_n)
     */

    // 8、广义赋值
    /**
     * a += b	a.plusAssign(b)
     * a -= b	a.minusAssign(b)
     * a *= b	a.timesAssign(b)
     * a /= b	a.divAssign(b)
     * a %= b	a.remAssign(b), a.modAssign(b)（已弃用）
     */

    // 9、相等与不等操作符
    /**
     * a == b	a?.equals(b) ?: (b === null)
     * a != b	!(a?.equals(b) ?: (b === null))
     *
     * 注意：=== 和 !==（同一性检查）不可重载，因此不存在对他们的约定。
     */

    // 10、比较运算符
    /**
     * a > b	a.compareTo(b) > 0
     * a < b	a.compareTo(b) < 0
     * a >= b	a.compareTo(b) >= 0
     * a <= b	a.compareTo(b) <= 0
     */

    // 11、属性委托操作符
    /**
     * provideDelegate、 getValue 以及 setValue 操作符函数
     */
}