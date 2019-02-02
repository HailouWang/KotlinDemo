package P_Others

class A {
    var a = 1

    inner class B {
        var myInt: Int = 3
        var myString: String = "string"

        fun Int.test() {
            var a1 = this
            println("this 对应接收者，即：一个Int，.号左边的对象" + a1 + ",this :" + this)

            var a2 = this@test
            println("this@test 对应接收者，即：一个Int，.号左边的对象" + a2 + ",this :" + this@test)

            var b = this@A
            println("this@A表示外部类：" + b)

            var c = this@B
            println("this@B表示内外部类：" + c)
        }

        var funString1 = lambda@ fun String.() {
            var d = this // funString的接收者
            println("lambda@ ：" + d)
        }

        var funString2 = { s: String ->
            var d = this //funString2 的接收者
            println("---> ：" + d)
        }

        fun op() {
            myInt.test()

            myString.funString1()
            funString2("222222")
        }
    }

    fun test() {
        var b = B()
        println("b ===> " + b)
        b.op()
    }
}


fun main(args: Array<String>) {
    var a = A()
    a.test()
}