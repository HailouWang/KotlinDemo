package R_坑;

public class SingleInstance {
    static class Helper {
        private static final SingleInstance INSTANCE = new SingleInstance();
    }

    public static SingleInstance getInstance() {
        return Helper.INSTANCE;
    }

    private SingleInstance() {
    }
}
