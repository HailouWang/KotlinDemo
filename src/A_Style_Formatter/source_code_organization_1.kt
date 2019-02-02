//package A_Style_Formatter
//
////一、源代码组织-目录结构
////sample start
////混合项目中：Kotlin 源文件应当与Java源文件位与同一根目录中，并遵循相同的目录结构
//
////纯Kotlin项目中，和Java包管理类似。即：
////如果项目中所有代码位于 org.example.kotlin包及其子包中，那么包中的文件，
////应该直接放在源代码目录下。
//
//// org.example.kotlin.foo.bar中的文件应该放在源代码根目录下相应的foo/bar子目录中。
//
////sample end
//
////二、源代码组织-源文件名称
////Kotlin包含单个类：文件名应该与该类的名称相同，并追加.kt扩展名。
////Kotlin包含多个类或者只含有声明：选择一个能够描述该文件所包含内容的名称，避免使用Utils之类无意义词语
//
////三、源文件组织形式
////鼓励多个声明放在同一个Kotlin源文件中，只要这些声明在语义上彼此紧密关联
//
////定义扩展函数时：
////鼓励：放置在与类自身定义相同的地方
////仅对指定客户有意义：紧挨客户代码之后
//
////避免：为了收集所有Foo的扩展函数，创建一个文件
//
////四、源代码组织-类布局
////布局上依次是：
////属性声明与初始化块
////次构造函数
////方法声明
////伴生对象
//
////选择一个顺序：高级别优先或者相反
////嵌套类放在紧挨着使用其的代码之后，如果嵌套类仅被外部访问，嵌套类放置在最后，伴生对象之后。
//
////避免：
////不要按照字母顺序
////不要将常规方法与扩展方法分开，相关的东西放在一起
////
//
////五、源代码组织形式-接口实现布局
////实现成员的顺序应该与该接口的成员顺序相同
//
////六、源代码组织形式-重载函数
////类中，重载函数放置在一起
//
////七、命名规则，遵循Java命名约定
////包名：总是小写，且不使用下环线    😭😭😭😭😭😭😭😭😭😭
////类名和对象名：使用大写首字母并使用驼峰
//
////sample start
//open class DeclarationProcessor {}
//
//object EmptyDeclarationProcessor : DeclarationProcessor {}
////sample end
//
////函数名：函数、属性、局部变量 小写字母开头并使用驼峰，不适用下划线
//
////sample start
//fun processDeclarations() {}
//
//var declarationCount = 1
//
////sample end
//
////八、格式化
////Kotlin 遵循Java 编码规范
////缩进：使用4个空格缩进，不使用tab
////花括号：左括号放在结构起始处的行尾，右括号放在单独一行
////分号：在Kotlin中分号是可选的，因此换行很重要
//
////九、横向空白
////在二元操作符左右留空格，例如:（ a + b ）,例外：不要在 range to 操作符左右留有空白
////不要在一元运算符左右留空格
////控制流关键字(if、when、for、while)与相应的左括号之间留空格
//
////sample start
//fun ifFormat() {
//    if (true) {
//
//    }
//}
////sample end
//
////在//之后留有一个空格
//
//
//// 主构造函数声明、方法声明、方法调用的左括号之间   不要留有空格
////sample start
//class A(val x: Int) {}
//
//fun foo(x: Int) {}
//
//fun bar() {
//    foo(1)
//}
////sample end
//
//// 、[ 之后 或者 ] 、之前     绝不要留有空格
//// . 或者 ?. 左右     绝不要留有空格
//// 泛型<>括号前后  绝不要留有空格
////:: 前后    绝不要留有空格
////标记空类型的？的前面  绝不要留有空格
//
//
////十、冒号
////如下场景，冒号之前留有一个空格：
////1、分隔类型与超类型时
////2、委托给一个超类的构造函数或者同一个类的另一个构造函数时
////3、在Object关键字之后
//
////分隔声明与其类型时，冒号之前不要留空格，之后留一个空格
//var x: Int = 1
//
////十一、类头格式化
////构造函数少，写成一行
////sample start
//class Person(id: Int, name: String)
////sample end
//
////较长类头的类，每个主构造函数都在带有缩进的独立行中，右括号单独一个新行。
////sample start
//class Person(
//        id: Int,
//        name: String,
//        surname: String
//) {
//
//}
////sample end
//
////如果使用了继承，超类的构造函数调用或者接口列表应该与左括号在同一行。超类型构造函数放在首位，如果超类型比较多，冒号后面换行。
////sample start
//class Person(
//        id: Int,
//        name: String,
//        surname: String
//) : Human(id, name) {
//
//}
//
//class Person :
//        Human1,
//        Human2,
//        OtherHuman(
//                id: Int,
//                name: String,
//                surname: String
//                ) : Human(id, name) {
//
//}
//
////sample end
//
//// 十二、修饰符顺序
////public protected private internal
////expect /actual
////external
////override
////lateinit
////tailrec
////vararg
////inner
////enum /annotation
////companion
////inline
////infix
////opeartor
////data
//
////备注：注解在修饰符前
//
//// 十三、注解格式化
////注解通常放在单独的行，在依附的声明之前，并使用相同的缩进
////sample start
//@Target(AnnotationTarget.PROPERTY)
//annotation class JsonExclude
////sample end
//
////无参数的注解可以放在同一行
////sample start
//@JsonExclude
//@JvmField
//var x: String
////sample end
//
////无参数的注解可以和声明放在同一行
////sample start
//@Test
//fun foo() {
//}
////sample end
//
//// 十四、文件注解
////文件注解位与文件注释之后，package语句之前，
//// 并且使用一个空白行与package分开（区分其针对文件而不是包）
////sample start
//
//@file:JvmName("FooBar")
//
//package foo.bar
////sample end
//
//// 十五、函数格式化
////语法：
////fun longMethodName(
////        argument:ArgumentType = defaultValue,
////        argument2:AnotherArgumentType
////) : RuturnType {
////    //函数体
////}
//
//// 十六、单个表达式构成的函数体，首选使用表达式形式
//// sample start
//fun foo(): Int { //-->   不推荐
//    return 1
//}
//
//fun fooRecommend() = 1
//
////sample end
//
//// 十七、如果函数的表达式函数体育函数声明不适合放在同一行，
//// 需要将"="号留在第一行，且函数体缩进4个空格
////sample start
//fun f(x: String) =
//        x.length
//
////sample end
//
////  十八、属性格式化
////对于只读属性，请考虑使用单行格式：
////sample start
//val isEmpty: Boolean get() = size == 0
////sample end
//
//// 十九、格式化控制流语句
////如果控制语句有多行，那么将控制语句的每个后续条件起始处缩进4个空格，
////且 控制语句的右圆括号与函数体的左括号放在单独一行
////sample start
////        if(!component.isSyncing &&
////            !hasAnyKotlinRuntimeInScope(module)
////        ) {
////            return createKotlinNotConfiguredPanel(module)
////        }
////sample end
//
//// 二十、将else、catch、finally、以及do/while关键字之前的花括号放在同一行上
////sample start
////        if(condition){
////
////        }else{
////
////        }
////
////        try{
////
////        }catch(){
////
////        }finally{
////
////        }
////sample end
//
////二十一、方法调用格式化
////较长参数列表，左括号后添加一个换行符
////sample start
////        drawSquare(
////        x = 10,y = 10,
////        width = 100,height = 100,
////        fill = true
////        )
////sample end
//
//// 二十二、链式调用换行
////将 .字符 或者 ?. 操作符放在下一行，并带有单倍缩进
////sample start
//val anchor = owner
//        ?.firstChild
//        .sublings(forward = true)
//        .dropWhile { it is PsiComment || it is PsiWhiteSpace }
////sample end
//
////二十三、Lambda表达式
////花括号左右以及分隔参数与代码体的箭头左右留有空格，应尽可能将其放在圆括号外面传入
////sample start
//list.filter { it > 10 }
////sample end
//
////如果为lambda表达式分配一个标签，那么标签与左花括号之间不要留有空格
////sample start
//fun foo() {
//    ints.forEach lit@{
//
//    }
//}
////sample end
//
////如果参数列表太长无法放在一行，请将箭头单独一行
////sample start
//foo{
//    context : Context,
//    environment:Env
//    ->
//    context.configureEnnv(environment)
//}
////sample end
//
//
//
//
//
//
//
//
//
//
