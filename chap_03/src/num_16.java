
import java.util.Random;
import java.util.Scanner;


public class num_16 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        boolean stop = true;

        String input = "1";
        while(!input.equals("그만")){
            System.out.print("가위 바위 보!!>>");
            input = scanner.next();

            int com_input = random.nextInt(3);
            String com_input_Str = check_com_input(com_input);



            if (input.equals(com_input_Str)) {
                System.out.print("사용자 = " + input + " , 컴퓨터 = ");
                System.out.print(com_input_Str);
                System.out.println(", 비겼습니다.");

            } else {

                if (input.equals("가위")) {
                    if (com_input_Str == "바위") {
                        System.out.print("사용자 = " + input + " , 컴퓨터 = ");
                        System.out.print(com_input_Str);
                        System.out.println(", 컴퓨터가 이겼습니다.");
                    }
                    if (com_input_Str == "보") {
                        System.out.print("사용자 = " + input + " , 컴퓨터 = ");
                        System.out.print(com_input_Str);
                        System.out.println(", 사용가 이겼습니다.");
                    }
                }

                if (input.equals("바위")) {
                    if (com_input_Str == "보") {
                        System.out.print("사용자 = " + input + " , 컴퓨터 = ");
                        System.out.print(com_input_Str);
                        System.out.println(", 컴퓨터가 이겼습니다.");
                    }
                    if (com_input_Str == "가위") {
                        System.out.print("사용자 = " + input + " , 컴퓨터 = ");
                        System.out.print(com_input_Str);
                        System.out.println(", 사용가 이겼습니다.");
                    }
                }
                if (input.equals("보")) {
                    if (com_input_Str == "가위") {
                        System.out.print("사용자 = " + input + " , 컴퓨터 = ");
                        System.out.print(com_input_Str);
                        System.out.println(", 컴퓨터가 이겼습니다.");
                    }
                    if (com_input_Str == "바위") {
                        System.out.print("사용자 = " + input + " , 컴퓨터 = ");
                        System.out.print(com_input_Str);
                        System.out.println(", 사용자가 이겼습니다.");
                    }
                }

            }
        }


    }

    public  static  String check_com_input(int com_input){
        if (com_input==0) {

            return "가위";
        }
        else if (com_input==1){

            return "바위";
        }
        else{

            return "보";
        }
    }
}
