public class TestHelpers {
    private static TestHelpers instance;

    private TestHelpers() { }

    public static TestHelpers getInstance() {
        if (instance == null) {
            synchronized (TestHelpers.class) {
                if (instance == null) {
                    instance = new TestHelpers();
                }
            }
        }
        return instance;
    }

    // ... your code here...
}