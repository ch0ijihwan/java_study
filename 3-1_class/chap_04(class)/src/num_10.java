import java.util.Scanner;

class Dictionary{

    private static String [] kor = {"사랑", "아기","돈","미래","희망"};
    private static String [] eng = {"love","baby","money","future","hope"};
    public static String kor2Eng(String word) {


        for (int i = 0; i<kor.length;i++){
            if(word.equals(kor[i])){



               return word + "은 " + eng[i];
            }
            if(word.equals(eng[i])){


                return word + "은 " + kor[i];
            }


        }

        return  word + "는 " + "저의 사전에 없습니다.";

    }

}

public class num_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dictionary D = new Dictionary();

        while(true) {

            System.out.printf("한글 단어?");
            String scr_word = scanner.next();

            System.out.println( D.kor2Eng(scr_word));


            if(scr_word.equals("그만")){
                break;
            }
        }

    }
}
