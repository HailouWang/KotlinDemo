package A

fun main(args:Array<String>){
    //一、try catch表达式
    val result = try{
        2
    }catch (e:ArithmeticException){
        throw IllegalStateException(e)
    }

    println("result ---> $result")
}
