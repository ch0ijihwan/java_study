import java.util.*;

public class num8 {

    public <E> void m0(List<E> L, E e) {
        L.add(e);
    }

//    public <E> void m1(List<? extends E> L,E e){
//        L.add(e);
//    }

    public <E> void m2(List<? super E> L, E e){
        L.add(e);
    }

    public void m3(List L, Object e){
        L.add(e);
    }

    Number n =1;
    Integer a = (Integer) n;
}
