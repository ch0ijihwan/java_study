import java.util.Scanner;
import java.util.Random;

public class num_08 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("정수 몇개? ");
        int input_num = sc.nextInt();

        int[] array;
        array = new int[input_num];
        int count = 0; // 줄바꿈을 하기 위한 변수

        //기본 배열 셋
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(99)+1; //범위가 1부터 100까지 이기 때문에 0~99에 1을 더해준다.

        }


        while(check_num(array) != true){ // 중복되는 수가 있는지 확인하고, 만약 있다면  배열에 숫자를 다시 배정
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(99)+1;
            }
        }

        //출력 부분
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");
            count++;
            if(count %10 == 0){
                System.out.println();
            }

        }

    }

    static boolean check_num ( int[] numbers){
        int[] check_pro = new int[100];

        for (int i = 0; i < numbers.length; i++) {
            check_pro[numbers[i]] = check_pro[numbers[i]] + 1; //만약 존재하는 숫자면, 그 수에 해당하는 인덱스 번호에 1을 추가
            if (check_pro[numbers[i]] == 2) {// 1을 추가해줬을 시 2가 되었다면, 중복이 되기 때문에 return false;
                return false;
            }


        }
        return true;

    }
}