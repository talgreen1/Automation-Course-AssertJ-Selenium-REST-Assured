package selenium.exercises.finals.finals01;

public class MainClass {
    public static void main(String[] args) {

        WebTests tests = new WebTests();

        tests.init();
        tests.runTests();
        tests.teardown();

    }
}
