import java.util.Scanner;
 class Circle {
    private double x,y;
    private int radius;
    double area;


    public Circle(double x, double y, int radius){
        this.x = x;
        this.y =y;
        this.radius = radius;//x,y,radius 초기화 부분
        this.area = radius*radius * 3.14;

    }

    public void show(){
        System.out.println("("+this.x + ","+this.y + ") " + this.radius);

    }

}



public class CircleManager {
    public static void main(String[] args) {

        double temp = 0;
        int index =0;

        Scanner scanner = new Scanner(System.in);
        Circle[] c = new Circle[3];// 3개의 Circle 배열 선언


        for (int i = 0; i < c.length; i++) {
            System.out.printf("x, y, radius >> ");
            double x = scanner.nextDouble();// x값 읽기
            double y = scanner.nextDouble();// y 값 읽기
            int r = scanner.nextInt();// 반지름 읽기
            c[i] = new Circle(x,y,r) ; // Circle 객체 생성
        }

    for (int i =0; i<c.length;i++){// 원 넓이 중 최대값 찾기

        if (temp <c [i].area){
            temp = c[i].area;
            index = i;
        }


    }
        System.out.printf("가장 면적이 큰 원은 ");
        c[index].show();

        scanner.close();
    }
}
