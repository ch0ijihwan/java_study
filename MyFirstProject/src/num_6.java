import java.util.Scanner;

public class num_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1~99사이의 정수를 입력하시오 >> ");
        int num = scanner.nextInt();

        if (num / 10 == 3) {
            if (num % 10 == 3) {
                System.out.println("박수짝짝");
            } else if (num % 10 == 6) {
                System.out.println("박수짝짝");
            } else if (num % 10 == 9) {
                System.out.println("박수짝짝");
            } else {
                System.out.print("박수짝");
            }

        }
        else if (num / 10 == 6) {
            if (num % 10 == 3) {
                System.out.println("박수짝짝");
            } else if (num % 10 == 6) {
                System.out.println("박수짝짝");
            } else if (num % 10 == 9) {
                System.out.println("박수짝짝");
            } else {
                System.out.print("박수짝");
            }

        }
        else if (num / 10 == 9) {
            if (num % 10 == 3) {
                System.out.println("박수짝짝");
            } else if (num % 10 == 6) {
                System.out.println("박수짝짝");
            } else if (num % 10 == 9) {
                System.out.println("박수짝짝");
            } else {
                System.out.print("박수짝");
            }


        }

        else{
            if (num % 10 == 3) {
                System.out.println("박수짝");
            } else if (num % 10 == 6) {
                System.out.println("박수짝");
            } else if (num % 10 == 9) {
                System.out.println("박수짝");
            }

        }


    }
}
