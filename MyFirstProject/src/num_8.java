import java.util.Scanner;

public class num_8 {

    public static boolean inRect(int x, int y) {
        if ((x >= 100 && x <= 200) && (y >= 100 && y <= 200)) {

            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("x1,y1의 좌표값 입력 >>");
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        System.out.println("x2,y2의 좌표값 입력 >>");
        int x2 = s.nextInt();
        int y2 = s.nextInt();

        boolean point_Check_1;
        boolean point_Check_2;


        point_Check_1 = inRect(x1, y1);
        point_Check_2 = inRect(x2, y2);

        if (point_Check_1 == true || point_Check_2 == true){
            System.out.println("두 사각형은 충돌 합니다.");
        }
        else{
            System.out.println("두 사각형은 충돌 하지 않습니다.");
        }

    }


}
