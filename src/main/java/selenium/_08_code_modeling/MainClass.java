package selenium._08_code_modeling;

public class MainClass {
    public static void main(String[] args) {

        WebTests tests = new WebTests();

        tests.init();
        tests.runTests();
        tests.teardown();

    }
}
