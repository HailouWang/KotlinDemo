package C_ClassAndObject.D_data

//一、Kotlin支持泛型
//sample start
class GenericBox<T>(t: T) {
    val value = t
}

//使用
val genericBox1 = GenericBox<Int>(1)
//允许省略类型/泛型参数
val genericBox2 = GenericBox(1);
//sample end

//二、Kotlin无通配符，但存在：声明处型变和类型投影
// 声明处泛型：https://www.jianshu.com/p/0c2948f7e656
// EffectiveJava 利用限制通配符来提升API的灵活性，java中的泛型是不型变的，
// 即：List<String>不是List<Object>的子类
// 生产者：你只能从中读取的对象成为生产者 Extens  Producer-Extends
// 消费者：你只能写入的对象为消费者  Super Consumer-Super

//声明处泛型(型变)：该接口不存在任何以T作为参数的方法，方法返回T类型。
// 声明处泛型负责向编译器解释泛型类型,使用out作为修饰符，确保只生产，不消费。
// 即：只能输出，不能写入，从out上也能看出来
//sample start
interface GenericSource<out T>{
    fun nextT():T
}

fun genericSourceDemo(strs:GenericSource<String>){
    val objects:GenericSource<Any> = strs //无编译错误，因为T 是out参数
}
//sample end

// 备注：当一个类C的泛型参数T 被声明为out时，它就只能出现在C的成员方法的输出位置。
// 但是：可以 C<超类> 可以安全的作为C<子类>的超类型

// 关键字in也是声明处泛型关键字，只可以被消费而不能被生产，
// 即：只可以写入，不能输出，从in关键字上也能看得出来

//sample start
class Comparable<in T>{
    fun compareTo(other:T):Int{
        return 0
    }
}

fun genericComparableDemo(x:Comparable<Number>,x1:Comparable<Double>){
    x.compareTo(1.0) //1.0拥有Double类型， 它是Number的子类型，
    // 另外，我们可以将x赋值给Comparable<Double>
    val y:Comparable<Double> = x

    var a:Int = 3;
    var b:Double = 4.0
    //错误
//    b = a
    var c:Comparable<Double> = Comparable<Double>()
    var d:Comparable<Number> = Comparable<Number>()

    c = d
    d = c

    // 下面是错误的
//    val z:Comparable<Number> = x1

    // 由上可知：in修饰的泛型，是写入时逻辑，只能写入T的
}
//sample end

// 备注：消费者IN，生产者OUT
// 我们之所以可以安全地将 ArrayList<Orange> 向上转型为 List<? extends Fruit>，
// 是因为编译器限制了我们对于 List<? extends Fruit> 类型部分方法的调用。
// 例如void add(T t)方法，以及一切参数中含有 T 的方法（称为消费者方法），
// 因为这些方法可能会破坏类型安全，只要限制这些方法的调用，
// 就可以安全地将 ArrayList<Orange> 转型为 List<? extends Fruit>。
// 这就是所谓的协变，通过限制对于消费者方法的调用，使得像 List<? extends Fruit> 这样的类型
// 成为单纯的“生产者”，以保证运行时的类型安全。

// 编译器限制了我们对于 List<? super Fruit> 类型部分方法的调用。
// 例如T get(int pos)方法，以及一切返回类型为 T 的方法（称为生产者方法），
// 因为我们不能确定这些方法的返回类型，只要限制这些方法的调用，
// 就可以安全地将 ArrayList<Object> 转型为 List<? super Fruit>。
// 这就是所谓的逆变，通过限制对于生产者方法的调用，
// 使得像 List<? super Fruit> 这样的类型成为单纯的“消费者”。


// 三、类型投影
// 类型投影相当于"？ extends Object"或者 "？ super Object"

// 四、星投影
// Function<*,String>

// 五、泛型函数
// 声明

//fun <T> singletonList(item:T) :List<T>{
//    return null
//}

// 调用
//val l = singletonList<Int>()


// 六、泛型约束
// " ： " 约定上界

//fun <T : Comparable<T>> sort(list:List<T>){
//    return null
//}

// 默认上界是 Any，如果有多个上界，使用where关键字

















































