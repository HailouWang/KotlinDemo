package C_ClassAndObject.F_Enum

// 一、枚举用来实现类型最安全的枚举
// sample start
enum class Direction{
    NORTH,SOUTH,WEST,EAST
}
// sample end

// 二、初始化
// sample start
enum class Color(val rgb:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
// sample end

// 三、枚举中也可以声明自己的匿名类
//sample start
enum class ProtocolState{
    WAITING{
        override fun signal(): ProtocolState {
            return TALKING
        }
    },

    TALKING{
        override fun signal(): ProtocolState {
            return WAITING
        }

    };

    abstract fun signal():ProtocolState
}
//sample end

// 四、使用枚举常量
// 可以通过EnumClass.valueOf(value:String):EnumClass
// EnumClass.values():Array<EnumClass>
// 来访问枚举常量




















