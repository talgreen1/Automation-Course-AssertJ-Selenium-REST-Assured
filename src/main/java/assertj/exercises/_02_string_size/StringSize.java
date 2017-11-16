package assertj.exercises._02_string_size;


import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSize {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter 2 strings with the same length: ");

        String s1 = in.next();
        String s2 = in.next();

        assertThat(s1).hasSameSizeAs(s2);





    }

}
