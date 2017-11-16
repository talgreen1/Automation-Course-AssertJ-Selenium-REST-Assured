package assertj.exercises._01_number;


import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Number {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter 2 digit number: ");

        int num = in.nextInt();

        assertThat(num).isLessThanOrEqualTo(99).isGreaterThanOrEqualTo(10);




    }

}
