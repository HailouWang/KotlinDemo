package B_Basic

/**
 * @author HailouWang
 */
fun main(args: Array<String>) {
    //一、字符串使用String标识，不可变。字符串特殊的数组，使用str[1]来访问特定下标字符
    val str = "abcdefg"
    //sample start
    for (char in str) {
        println("字符串内容：" + char)
    }
    //sample end

    //二、使用"+"操作符来连接字符串
    //sample start
    val str1 = "abc" + 1
    println("'+'操作符之后：----->" + str1)

    //三、字符串字面值-->转义字符
    //sample start
    val str2 = "Hello World \n 换行，Hello Boy!"
    println("转义字符---> $str2")
    //sample end

    //四、字符串字面值-->原始字符串，可以包含换行和任意文本
    val text = """
        for(c in "foo"){
        println(c)
        }
        """
    println("text 原始格式 ---> " + text)

    val text1 = """
        |Tell me and i forget.
        |Teach me and I remember.
        |Involve me and I learn.
        |(Benjamin Franklin)
        """.trimMargin(/*"|"*/)

    println("text1 去掉空格 ---> " + text1.trimMargin())

    //五、字符串模板，即字符串中包含一小段代码，会求值并将结果合并到字符串中。以美元 $ 开头.
    //sample start
    val i = 10
    println("i= $i") // i= 10

    val s = "abc"
    println("$s.length is ${s.length}") // abc.length is 3
    //sample end

    //六、原始字符串和转义字符串都支持模板，原始字符串中表示"$"
    val price = """
        > ${'$'}9.99
        """.trimMargin(">")
    println("打印\$符号---->" + price)
}