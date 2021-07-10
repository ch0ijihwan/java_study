public class OuterClass {
    static  int staticField = 30;
    int instanceField;

    static void staticMethod(){}
    void instanceMethod(){}


    class InnerClass{
        int instanceField;

        void instanceMethod(){}

        void method(){
            staticField = 1;
            instanceField = 1;
            instanceField=1;
            System.out.println(this.instanceField);
            staticMethod();
            instanceMethod();

            OuterClass.this.instanceMethod();
        }
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass ic = oc.new InnerClass();

        ic.method();
    }
}
