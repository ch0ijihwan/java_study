import java.util.Random;
import java.util.Scanner;

public class num_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean [] check_array;
        check_array = new boolean[100]; //100개의 배열 생성. 생성시 모든 인덱스에 false가 들어감.

        System.out.println("정수 몇개?");
        int input_num = scanner.nextInt();

        int [] array;
        array = new int [input_num];


        for (int i = 0; i<array.length;i++){

            int temp = random.nextInt(99)+1;

            if(check_array[temp-1]==false){ // 값이 false 경우. 즉, 기존에 넣지 않았을 경우는
                array[i]=temp;              //값을 넣어줌.
                check_array[temp-1] = true;

            }
            else{                           // 이미 존재하는 값이 있었다면, 반복문 재실행
                i--;
            }

        }

        //출력 부분
        int count = 0;
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
            count++;
            if(count %10 == 0){
                System.out.println();
            }
        }

    }
}
