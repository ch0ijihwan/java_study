import java.util.Random;


public class num_10 {
    public static void main(String[] args) {
        Random random = new Random();

        int[][] ran_array;
        ran_array = new int[4][4];

        int[][] check_array;
        check_array = new int[4][4];
        int count = 0;

        for (int i = 0; i < 12; i++) { //12개의 램덤 인덱스에 값을 넣어줌
            int ran_1 = random.nextInt(4);
            int ran_2 = random.nextInt(4);
            //램덤 인덱스 배열안에 값이 0이라면 램덤 값을 넣어줌
            if (ran_array[ran_1][ran_2] == 0) {
                ran_array[ran_1][ran_2] = random.nextInt(10)+1;
            //이미 값이 존재한다면 재실행
            }else {
                i --;
            }
        }

        //출력 부분
        for (int i = 0; i < ran_array.length; i++) {
            for (int j = 0; j < ran_array[i].length; j++) {

                System.out.print(ran_array[i][j] + "  ");

            }
            System.out.println();
        }
    }

}
