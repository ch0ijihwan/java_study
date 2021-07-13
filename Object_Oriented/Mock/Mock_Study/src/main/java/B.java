public class B {
    private A a;

    private int age = 17;


    public B(A a) {
        this.a = a;
    }

    public int isOlderThanA() {

        if (a.isOlder(age)) {
            return 1;
        }
        return 0;

    }

    void check() {
        a.check();
        a.check();
        a.check();

    }
}
