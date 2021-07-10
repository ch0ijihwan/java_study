

public class num2 {


    public static void print(Parent1 p) {
        System.out.println(p.i);
        System.out.println(p.get());

    }

    public static void main(String[] args) {

        Parent1 p = new Parent1();
        System.out.println(p.i);
        System.out.println(p.get());

        Child c = new Child();
        System.out.println(c.i);
        System.out.println(c.get());


        Parent1 p2 = new Child();
        System.out.println(p2.i);
        System.out.println(p2.get()); // 동적바인딩이 되어서, 업 캐스팅에 의  오버라이딩 된, Child의 get 호출

        print(c); //print 함수가 Parent1 의 객체를 빋기 때문에 10, 8  순으로 출력. 즉, Chile c는 Parent1으로 강제 형변한 되어서 들어감.
        print(p2);

    }
}


class Parent1{
    int i = 10;
    public int get(){
        return i;
    }
}

class  Child extends Parent1{
     int i = 8;
    public int get(){
        return i;

    }
}