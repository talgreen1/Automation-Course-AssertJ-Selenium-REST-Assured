package assertj._02_assertj;


import org.assertj.core.api.SoftAssertions;

public class SoftAssert {
    public static void main(String[] args) {
        String firstName = "Frodo";
        int[] array = {1, 2, 3, 5, 6, 7, 8, 9, 10};


        SoftAssertions sa = new SoftAssertions();

        sa.assertThat(firstName.length()).isEqualTo(3);
        sa.assertThat(firstName).startsWith("Fr");
        sa.assertThat(firstName).endsWith("aaa");

        sa.assertAll();


    }

}
