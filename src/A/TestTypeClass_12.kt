package A

fun main(args: Array<String>) {
    //sample start
    val rectangle = Rectangle(5.0, 2.0)
    val triangle = Triangle(3.0, 4.0, 5.0)
    //sample end

    println("Area of rectangle is ${rectangle.calculateAea()}, " +
            "its perimeter is ${rectangle.perimeter}")

    println("Area of triangle is ${triangle.calculateAea()}, " +
            "its perimeter is ${triangle.perimeter}")
}

abstract class Shape(val sides: List<Double>) {
    //周长
    val perimeter: Double get() = sides.sum()

    abstract fun calculateAea(): Double
}

interface RectangleProperites {
    val isSquare: Boolean
}

//矩形
class Rectangle(var height: Double,
                var length: Double)
    : Shape(listOf(height, length, height, length)), RectangleProperites {
    override val isSquare: Boolean
        get() = height == length

    override fun calculateAea(): Double {
        return height * length
    }
}

//三角形
class Triangle(var sideA: Double,
               var sideB: Double,
               var sideC: Double)
    : Shape(listOf(sideA, sideB, sideC)) {
    override fun calculateAea(): Double {
        val s = perimeter / 2
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }
}