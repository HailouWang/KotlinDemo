package T_Java;

public class DoubleCheckSingleInstance {

    private static /*volatile*/ DoubleCheckSingleInstance doubleCheckSingleInstance;

    private DoubleCheckSingleInstance() {
    }

    public static DoubleCheckSingleInstance getInstance() {
        if (doubleCheckSingleInstance == null) {
            synchronized (DoubleCheckSingleInstance.class) {
                if (doubleCheckSingleInstance == null) {
                    doubleCheckSingleInstance = new DoubleCheckSingleInstance();
                }
            }
        }

        return doubleCheckSingleInstance;
    }

    public static void main(String[] args) {
        DoubleCheckSingleInstance.getInstance();
    }
}
