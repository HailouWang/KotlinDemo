package R_坑;

public class KengJava {
    public static void main(String[] args) {

        // Java 访问 Kotlin 中的常量
        Keng.Companion.getEMPTY();
        Keng.Companion.isEmpty("");

        KengInstance.INSTANCE.getEMPTY();

        // Java 访问 Kotlin 中带有 JvmField 修饰的常量，无需 Companion
        String FULL_NUMBER = Keng.FULL_NUMBER;
        Keng.isNumber("");

        // JvmOverloads 注解的作用
        Keng.isNumberWithOverLoads();
        Keng.isNumberWithOverLoads("");

//        JavaKengBase keng = new Keng();
//        keng.onDialogCreate(null);

        Keng keng = new Keng();
        keng.testTodo();
    }
}
