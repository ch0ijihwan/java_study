import java.util.InputMismatchException;
import java.util.Scanner;


public class num_15 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int m = 1, n = 0;


        while (m!=0) {
            System.out.println("곱하고자 하는 두 수 입력>>");
            try {
                n = scanner.nextInt();
                m = scanner.nextInt();
                System.out.print(n + "x" + m + "=" + n * m);

            } catch (InputMismatchException e) {
                System.out.println("실수를 입력하면 안됩니다.");
            }
        }

        scanner.close();


    }

}
