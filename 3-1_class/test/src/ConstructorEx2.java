class D{
    int a;
    public D(){
        System.out.println("정");
        this.a=55555;
    }
    public D(int a){
        this.a=a;
        System.out.println("너");
    }
}
class E extends D{
    public E(){
        super(18);
        System.out.println("잘생겼다");
    }
    public E(double f){
        System.out.println("말");
    }
}
class F extends E{
    public F(){
        System.out.println("는구라");
    }
}
public class ConstructorEx2 {
    public static void main(String args[]){
        E e=new E();
        System.out.println(e.a);
        E t=new E(5.5);
        System.out.println(t.a);
        F k=new F();
    }
}

