import java.util.Scanner;


public class num_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("2자리 수 정수 입력(10~99)>>");
        int num = scanner.nextInt();



        if (num/10 == num%10 ){
            System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
        }


    }
}
