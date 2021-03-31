package Training_sacnner_0330;
import java.util.Scanner;


public class num_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 세개 입력 >>");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();


        if (a>b && a>c){
            if(b>c){
                System.out.println("중간값은 "+b);
            }
            if(c>b){
                System.out.println("중간값은 "+c);

            }


        }
        else if(b>a&&b>c){
            if(a>c){
                System.out.println("중간값은 "+a);
            }
            if(c>a){
                System.out.println("중간값은 "+c);

            }
        }
        else if (c>a&&c>b){
            if(a>b){
                System.out.println("중간값은 "+a);

            }
            if(b>a){
                System.out.println("중간값은 "+b);
            }

        }



    }

}
