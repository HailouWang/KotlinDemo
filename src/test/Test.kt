package test

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(args:Array<String>){
    var intent:Intent? = null

    intent?:
    run{
        print("intent is : $intent")
    }

    intent?.let {  }

    val action = intent?.action ?: return

    print("action is : $action")

    var intent2:Intent = Intent()
    println("gfhfh : "+intent2.gfhfh)
}

class Intent{
    var action = 1
    var fdsf = 1
    var gfhfh = 1
    get() = 4;
}