package T_Java;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myClassLoader = customClassLoader();

        Object obj = myClassLoader.loadClass(ClassLoaderTest.class.getName()).newInstance();

        System.out.println(obj instanceof ClassLoaderTest);


        ClassLoader.getSystemClassLoader();
    }

    static ClassLoader customClassLoader() {
        return new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String classFileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(classFileName);
                if (is == null) {
                    return super.loadClass(name);
                }

                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return super.loadClass(name);
            }
        };
    }
}