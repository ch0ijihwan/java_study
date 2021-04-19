public class ex1 {

    public static class Circle{
        int radius;
        String name;

        public Circle(){
        }

        public double getArea(){
            return 3.14 * radius*radius;
        }
    }
    public static void main(String[] args) {

        Circle pizza; // 레퍼런스 변수 pizza 선언
        pizza = new Circle(); //Circle 객체 생성
        pizza.radius = 10;
        pizza.name = "맛있는 자바 피자";
        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + pizza.getArea());




    }
}
