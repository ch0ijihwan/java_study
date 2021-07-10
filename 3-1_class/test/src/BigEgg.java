class Egg{

    protected class Yolk{
        public Yolk() {
            System.out.println("Egg.Yolk");
        }
        public  void f() {
            System.out.println("Egg.Yolk.f()");
        }

    }

    private Yolk y = new Yolk();
    public Egg(){
        System.out.println("New Egg()");
    }
    public void insertYolk(Yolk yy) {y = yy;}
    public void g() {y.f();}
}


public class BigEgg extends Egg{
    public class Yolk extends Egg.Yolk{
        public Yolk(){
            System.out.println("BigEgg.Yolk()");
        }
        public void f(){
            System.out.println("BigEgg.Yolk.f()");
        }
    }
    public BigEgg(){insertYolk(new Yolk());}

    public static void main(String[] args) {
//        Egg e = new BigEgg();
//        e.g();


        String str1 = "Happy ";
        String str2 = str1;
        str2 += "New Year";
        str1 = str2.substring(4);
        System.out.println(str1 + str2);

    }
}
