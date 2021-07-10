import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListlteratorEX {


    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple","Orange","Mango","Strawberry");
        list = new ArrayList<>(list);

       ListIterator<String> litr = list.listIterator();


       //forward

        while (litr.hasNext()){
            String str = litr.next();
            System.out.print(str + "\t");

            if(str.equals("Orange")){
                litr.add("After_Orange");
            }

        }
        System.out.println();
        //backwards
        while (litr.hasPrevious()) {
            String str = litr.previous();
            System.out.print(str + "\t");

            if (str.equals("Mango")) {
                litr.add("Before_Mange");

            }
        }
        System.out.println();

            for(String str1: list)
                System.out.print(str1 + "\t");
            System.out.println();



    }
}
