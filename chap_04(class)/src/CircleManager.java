import java.util.Scanner;
 class Circle {
    private double x,y;
    private int radius;

    public Circle(double x, double y, int radius){
        this.x = x;
        this.y =y;
        this.radius = radius;//x,y,radius 초기화 부분

    }

    public void show(){
        System.out.println("("+this.x + ","+this.y + ") " + this.radius);

    }

}



public class num_5 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Circle[] c = new Circle[3];// 3개의 Circle 배열 선언


        for (int i = 0; i < c.length; i++) {
            System.out.printf("x, y, radius >> ");
            double x = scanner.nextDouble();// x값 읽기
            double y = scanner.nextDouble();// y 값 읽기
            int r = scanner.nextInt();// 반지름 읽기
            c[i] = new Circle(x,y,r) ; // Circle 객체 생성
        }

    for (int i =0; i<c.length;i++){
        c[i].show();//모든 객체 출력
    }
        scanner.close();
    }
}
