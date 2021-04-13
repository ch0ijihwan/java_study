import java.util.Scanner;

public class num_12_1 {
    public static void main(String[] args) {

       int result = 0;
        Scanner s = new Scanner(System.in);

        System.out.print("연산>>");
        int in_num_1 = s.nextInt();
        String math_Symbol = s.next();
        int in_num_2 = s.nextInt();




        if (math_Symbol.equals("+")){

             result = in_num_1 + in_num_2;
            System.out.print(in_num_1+math_Symbol+in_num_2+"의 계산 결과는 ");
            System.out.print(result);
        }
        else if(math_Symbol.equals("-")){
            result = in_num_1 - in_num_2;

            System.out.print(in_num_1+math_Symbol+in_num_2+"의 계산 결과는 ");
            System.out.print(result);
        }
        else if(math_Symbol.equals("*")){
            result = in_num_1 * in_num_2;

            System.out.print(in_num_1+math_Symbol+in_num_2+"의 계산 결과는 ");
            System.out.print(result);
        }
        else if(math_Symbol.equals("/")){
            if (in_num_2 == 0){
                System.out.println("0으로 나눌 수 없습니다.");

            }
            else {
                result = in_num_1 / in_num_2;
                System.out.print(in_num_1+math_Symbol+in_num_2+"의 계산 결과는 ");
                System.out.print(result);
            }

        }





    }
}
