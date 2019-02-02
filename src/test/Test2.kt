package test

fun main(args:Array<String>){
    var b = true;
    var a:Int = if(b){
        1
        2
        null
        3
        4
        sub()
    }else{
        0
    }

    print("a : $a")

    var c = a + 1
}

fun sub():Int{
    return 5;
}