package selenium.exercises.waits.wait01;

public class MainRunner {
    public static void main(String[] args) {
        PurchaseTests tests = new PurchaseTests();

        tests.init();
        tests.runTests();
        tests.teardown();
    }
}
