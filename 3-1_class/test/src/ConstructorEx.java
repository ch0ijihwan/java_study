class A{
    int a;
    public A(){
        System.out.println("백웅기");
    }
    public A(int a){
        System.out.println("이성엽");
        this.a=a;
    }
    void midtermexam(){
        System.out.println("김유진");
    }
}

class B extends A{
    int a;
    public B(int a){
        System.out.println("차윤성");
        super.a=a;
    }
    public B(){
        System.out.println("♥김동우♥");
    }
    void midtermexam(){
        super.midtermexam();
        System.out.println("김도형");
    }
}
public class ConstructorEx{
    public static void main(String arg[]){
//        B a=new B(5);
//        System.out.println(a.a);
//
//        a.a=7;
//        System.out.println(a.a);
//   //
//        a.midtermexam();
//        A t=new B();
//        t.midtermexam();
//        A b=new A();
//        b.midtermexam();




            String s="hello world";
            String tmp="";
            for(int i=0;i<s.length();++i)
            {
                tmp = tmp + s.charAt(s.length()-i-1);
            }
            System.out.println(tmp);
        }


}
