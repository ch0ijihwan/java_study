class SuperObject {

    protected String name;

    public void paint() {
        draw();
    }
    public SuperObject(){
        name="남주혁";
    }
    public void draw() {
        System.out.println(name);
    }
    public SuperObject(String a){
        name=a;
        this.draw();

    }
}

public class SubObject extends SuperObject {
    protected String name;
    public SubObject(){
        super("서강준");
    }
    public SubObject(String a){
        System.out.println(name);
    }
    public void draw() {
        name = "김희선";
        super.name = "한지민";
        super.draw();
        System.out.println(name);
    }

    public static void main(String[] args) {
        SuperObject b = new SubObject();
        b=new SubObject("지창욱");
        b.paint();
    }
}
