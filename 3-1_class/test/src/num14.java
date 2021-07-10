interface I1 extends I2 {void f();}

interface I2{default void f(){
    System.out.println("f() in I2");
}}
interface I3{void f();}

interface I4{static void f(){
    System.out.println("f() in I4");
}}

abstract class AC1{
    void f(){
    System.out.println("f() in AC");
}}

abstract class  AC2{abstract void f();}

class  C1 extends AC1 implements I1,I3,I4{
    public void f(){
        super.f();
        System.out.println(("f() in C"));
    }

}

class C2 extends AC2 implements I2,I3,I4
{
    public void f(){


        I2.super.f();
        I4.f(); // I4의 f()는 static이라서  super 사용안함

        System.out.println("f() in C");
    }
}



public class num14 {

    public static void main(String[] args) {
        I2 object1 = new C1();
        object1.f();

        I3 object2 = new C2();
        object2.f();
    }

}
