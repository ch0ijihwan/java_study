public class B {

    private A a;

    private  int age = 13;

    public B( A a ){
        this.a = a;
    }


    public int isOlderThanA(){
        if(a.isOlder(this.age)){
            return 1;
        }
        return 0;
    }

    public void check(){
        a.check();
    }
}
