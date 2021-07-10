//넓이와 높이를 입력받아 사각형의 합을 출력하는 프로그램을 작성하라.
import java.util.Scanner;

public class ex2 {
    static class Rectangle {
        int width;
        int height;

        Rectangle(int width, int height) {
            this.height = height;
            this.width = width;
        }

        int getArea() {
            return width * height;

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("사각형의 너비와 높이를 알려주세요  > >");
        Rectangle rect1 = new Rectangle(scanner.nextInt(), scanner.nextInt());

        System.out.println("사각형의 너비는 " + rect1.getArea() +" 입니다.");

    }
}
