package B_Basic

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    //一、Boolean类型有两个值：true 和 false
    val b1: Boolean = true;
    var b2: Boolean? = null

    if(b2 == true){

    }else{
        //b2 是false或者null
    }


    //二、布尔运算符
    // || 短路逻辑或
    // && 短路逻辑与
    // ！ 逻辑非
    fun parse1(): Boolean {
        println("parse1 ---->")
        return true
    }

    fun parse2(): Boolean {
        println("parse2 ---->")
        return false
    }

    val bool1 = parse1() || parse2()
    println(" || ----> $bool1")

    val bool2 = parse2() && parse1()
    println(" && ---> $bool2")
}