import java.util.Arrays;
import java.util.Scanner;


public class num_14 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String [] course = {"Java", "C++","HTML5","컴퓨터구조","안드로이드"};
        int score[] = {95,88,76,62,55};

        while (true){
            System.out.print("과목 이름 >>");
            String input  = scanner.next();

            if(input.equals("그만")){
                break;
            }

            int count = 0;

            for(int i = 0; i<course.length;i++){//점수 확인

               if(input.equals(course[i])){
                    System.out.print(course[i] + "점수는 ");
                    System.out.println(score[i]);
                    count ++;
                }
            }
            if ( count == 0){
                System.out.println("없는 과목입니다.");
            }
        }
    }
}
