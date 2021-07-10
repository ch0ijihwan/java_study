import java.util.Scanner;

public class num_06 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.print("금액을 입력하시오>>");
        int num = s.nextInt();
        int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < unit.length; i++) {
            if (num / unit[i] != 0) { // 잔돈의 갯수가 없을 경우 출력하지 않음.
                System.out.println(unit[i] + "원 짜리 : " + num / unit[i] + "개");
                num = num - ((num / unit[i]) * unit[i]); //잔돈으로 이미 빠져나간 금액을 전체 금액에서 제외해줌.
            }
        }


    }
}

