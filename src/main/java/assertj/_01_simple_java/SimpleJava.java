package assertj._01_simple_java;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class SimpleJava {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter an even number:");
        int num = in.nextInt();

        if (num % 2 != 0){
            throw new AssertionError(String.format("The number [%d] is not an even number", num));
        }

        System.out.printf("%nThank you for entering an even number [%d].", num);
        in.close();
    }
}
