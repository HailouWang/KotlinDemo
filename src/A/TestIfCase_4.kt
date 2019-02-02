package A;

import java.io.File

//一、使用条件表达式
//sample start
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
//sample end

//二、if表达式写法
//sample start
fun maxOfWithIfLambda(a: Int, b: Int) = if (a > b) a else b
//sample end

fun main(args: Array<String>) {
    println("max of 0 and 42 is ${Math.max(0, 42)}")

    //-----------------------------

    println("max of 0 and 42 is ${maxOfWithIfLambda(0, 42)}")

    //三、if not null 缩写 (?)
    var files = File("Test").listFiles()
    println("file count is :" + (files?.size))

    //四、if not null and else 缩写 (?  ?:)
    println("file count is " + (files?.size ?: "empty"))

    //五、if null
    println("when file null,name is " + files ?: "empty")

    //六、if not null
    files?.let {
        println("when file not null " )
    }

    //七、映射可空值

    var result = files?.let { "存在文件" } ?: "文件不存在，默认值"

}
