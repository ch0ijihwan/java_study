import java.util.Scanner;


public class num_10 {


    public static boolean overLap(double x1,double y1,double r1,double x2,double y2,double r2){

        double dis = Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y2)));

        if (dis <= (r1+r2)){
            System.out.printf("두 원은 겹칩니다.");
            return true;
        }
        else{
            System.out.printf("두 원은 겹치치 않습니다.");
            return false;
        }

    }
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("x1,y1,r1을 차례대로 입력해주세요");
        double x1 = s.nextDouble();
        double y1 = s.nextDouble();
        double r1 = s.nextDouble();

        System.out.println("x2,y2,r2을 차례대로 입력해주세요");
        double x2 = s.nextDouble();
        double y2 = s.nextDouble();
        double r2 = s.nextDouble();
       overLap(x1,y1,r1,x2,y2,r2);
    }
}
