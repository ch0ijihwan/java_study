class ChildExceotion extends Exception{}
class GrandChildException extends  ChildException{}
public class num5 {
    public static void main(String[] args) {
        try{
            throw new GrandChildException();
        } catch ( GrandChildException g)
        {
            System.out.println("GrandChildException");
        }catch (ChildException c ){
            System.out.println("ChildException");
        }

        try {
            throw new GrandChildException();

        }catch (ChildException c){
            System.out.println("ChildException");
        }
    }
}