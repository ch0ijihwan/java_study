class Animal{
    static void eat(){
        System.out.println("동물 먹기");

    }
    void sound(){
        System.out.println("동물 소리");
    }
}


public class Cat extends Animal{

    public static void eat(){
        System.out.println("고양이 먹기");
    }
    void sound(){
        System.out.println("고양이 소리");
    }

    public static void main(String[] args) {
        Cat al = new Cat();
        Animal cl = new Cat();

        al.sound();
        cl.sound();
        al.eat();
        cl.eat();

    }

}
