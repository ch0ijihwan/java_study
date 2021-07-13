public class Calculator {

    int num1;
    int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int add(int num1, int num2){
        return num1 + num2;

    }

    public int sub(int num1,int num2){
        return num1 - num2;

    }

    public int  div(int num1, int num2) {
        return  num1/num2;


    }

    public int mul(int num1, int num2) {
        return  num1*num2;
    }
}
