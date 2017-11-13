package assertj._01_simple_java;

import java.util.Scanner;

/**
 * Need to enable assertsion in JVM by adding -ea switch
 */
public class AssertStatement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter an even number:");
        int num = in.nextInt();

        // Assert statement without message
        assert num % 2 == 0;

        // Assert statement with message
        assert num % 2 == 0 : "The number is no even";

        System.out.printf("%nThank you for entering an even number [%d].", num);
        in.close();
    }
}
