import java.util.Scanner;

public class num_04 {
    public static void main(String[] args) {

        Scanner alpa = new Scanner(System.in);

        char input_alpa = alpa.next().charAt(0);


        for ( ;   'a' <= input_alpa; input_alpa-- ) {
            for (char i = 'a'; i <= input_alpa; i++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
