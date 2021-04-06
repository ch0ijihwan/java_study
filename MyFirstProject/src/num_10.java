package Training_sacnner_0330;
import java.util.Scanner;


public class num_10 {


    public static boolean overLap(int x1,int y1,int r1,int x2,int y2,int r2){

        double dis = Math.sqrt((((x2-x1)*(x1-x2)) + ((y2-y1)*(y1-y2))));

        if (dis <= r1+r2){
            System.out.printf("두 원은 겹칩니다.");
            return true;
        }
        else{
            System.out.printf("두 원은 겹치치않습니다.");
            return false;
        }

    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("x1,y1,r1을 차례대로 입력해주세요");
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int r1 = s.nextInt();

        System.out.println("x2,y2,r2을 차례대로 입력해주세요");
        int x2 = s.nextInt();
        int y2 = s.nextInt();
        int r2 = s.nextInt();
        System.out.println(overLap(x1,y1,r1,x2,y2,r2));
    }
}
