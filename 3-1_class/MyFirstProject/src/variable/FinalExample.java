package variable;

public class FinalExample {
    // Memver variale (in c++)
    //Field (in java)

    public static final double PI_VALUE;

    //Static Imitializatiomn Block
    static {
        PI_VALUE = 3.14;
    }


    //Constructor 생성자
    // public final double PI_VALUE; 이나
    // final double PI_VALUE; 인 경우 생성자로 초기화
   public FinalExample(){
        //PI_VALUE = 3.14; // 이미 static 에서 초기화해서 에러남
   }

    public static void main(String[] args) {
        final double PI ;
        int radius = 1;

        PI = 3.14;
       // PI = 5.14;

        double perimeter = 2 * PI * radius;
    }
}
