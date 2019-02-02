package C_ClassAndObject.N_generic

interface Source1<out T> {
    fun next(): T
}

// 协变
fun demo1(datas: Source1<Double>) {
    val objects: Source1<Number> = datas
}

interface Source2<in T> {
    fun next(t: T)
}

// 逆变
fun demo2(datas: Source2<Number>) {
    val objects: Source2<Double> = datas
}

interface Source3 {

}