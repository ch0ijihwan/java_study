import java.util.Random;
import java.util.Scanner;

public class Open_Challenge_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int input_num = 0;

        int min =0;
        int max =99;
        String yes_Or_no;

        while (true) {
            int card_num = random.nextInt(100);
            System.out.println("수를 결정하였습니다. 맞추어 보세요.");
            System.out.printf("%d - %d", min, max);

            input_num = scanner.nextInt();
            while (input_num != card_num) {
                if (input_num == card_num) {



                    break;
                } else if (input_num < card_num) {
                    System.out.println("더 높게");
                    min = input_num;
                    System.out.printf("%d - %d \n", min, max);
                } else if (input_num > card_num) {
                    System.out.println("더 낮게");
                    max = input_num;
                    System.out.printf("%d - %d \n", min, max);
                }
                input_num = scanner.nextInt();

            }
            System.out.print("맞았습니다. \n");

            System.out.println("다시하시겠습니까? (y/n)");
            yes_Or_no = scanner.next();
            if(yes_Or_no.equals("n")){
                break;
            }
        }
    }
}
