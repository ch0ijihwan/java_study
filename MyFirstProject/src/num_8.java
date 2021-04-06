package Training_sacnner_0330;

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

        System.out.println(inRect(x1, y1));
        System.out.println(inRect(x2, y2));


    }


}
