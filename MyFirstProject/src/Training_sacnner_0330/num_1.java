package Training_sacnner_0330;
import java.util.Scanner;
public class num_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원화를 입력하세요(단위 원)>>");

        int don  = scanner.nextInt(); //돈 읽기
        float dal = don/1100;
        System.out.print(don+"원은 $"+dal+"입니다.");

        scanner.close();

    }
}
