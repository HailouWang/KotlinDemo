package T_Java;

import java.lang.ref.WeakReference;

public class ClassGc {

    public Object instance = null;

    public static void main(String[] args) {
//        ClassGc classGcA = new ClassGc();
//        ClassGc classGcB = new ClassGc();
//
//        classGcA.instance = classGcB;
//        classGcB.instance = classGcA;
//
//        classGcA = null;
//        classGcB = null;
//
//        // 按照引用计数法，此时 classGcA、classGcB 可以被回收吗？
//        System.gc();



//        byte[] myByteArray = new byte[1];
//        WeakReference weakReference = new WeakReference(myByteArray);
//        System.out.println(weakReference.get()==null);
//        System.gc();
//        System.out.println(weakReference.get()==null);
// ------------------
        WeakReference weakReference = new WeakReference(new byte[1]);
        System.out.println(weakReference.get()==null);
        System.gc();
        System.out.println(weakReference.get()==null);
    }
}
