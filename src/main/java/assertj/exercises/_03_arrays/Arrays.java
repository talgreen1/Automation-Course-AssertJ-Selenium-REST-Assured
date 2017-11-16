package assertj.exercises._03_arrays;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class Arrays {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter numbers (-99 to end): ");

        int num = in.nextInt();

        while(num != -99){
            list.add(num);
            num = in.nextInt();
        }



        assertThat(list).isNotEmpty().contains(10).doesNotContain(13,666).doesNotHaveDuplicates();
        assertThat(list.size()).isGreaterThanOrEqualTo(5);





    }

}
