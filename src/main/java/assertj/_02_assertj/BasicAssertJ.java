package assertj._02_assertj;




import static org.assertj.core.api.Assertions.assertThat;


public class BasicAssertJ {
    public static void main(String[] args) {
        String firstName = "Frodo";
        int[] array = {1, 2, 3, 5, 6, 7, 8, 9, 10};

//        assertThat(firstName).isEqualTo("Frodo");
//        assertThat(array).hasSize(9)
//                         .contains(3, 5)
//                         .doesNotContain(4);
//
//        assertThat(firstName).isNotEmpty().contains("ab").endsWith("ion");
//
//        assertThat(firstName.length()).isGreaterThanOrEqualTo(4);

        assertThat(firstName).as("Testing the first name").isEqualTo("hello");




    }

}
