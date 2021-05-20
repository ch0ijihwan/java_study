import java.util.Scanner;

class PhoneBook{
    public String name;
    private String tel;

    PhoneBook(String name, String tel) {
        this.name = name;
        this.tel = tel;

    }
    public String getName() {
        return name;
    }
    public String getTel() {
        return tel;
    }

}

public class num_8
{
    public static void main(String[] args) {
        int PhoneBook_number = 0;

        System.out.println("인원수>>");
        Scanner scanner = new Scanner(System.in);

        PhoneBook_number = scanner.nextInt();

        PhoneBook [] p = new PhoneBook [PhoneBook_number];

    for (int i =0 ; i<PhoneBook_number; i++){
        System.out.printf("이름과 전화번호(이름과 전화번호는 빈 칸없이 입력 >> ");
        String name = scanner.next();
        String tel = scanner.next();
        p[i] = new PhoneBook(name,tel);


        if (i == PhoneBook_number -1){
            System.out.println("저장 되었습니다.");
        }
    }

        while(true) {
            int i =0;
            System.out.print("검색할 이름 >>");
            String name = scanner.next();
            for( i=0; i<PhoneBook_number; i++) {
                if(name.equals(p[i].getName())) {
                    System.out.println(name+"의 번호는 "+p[i].getTel()+" 입니다.");
                    i--;
                    break;
                }
            }
            if(name.equals("그만")) break;
            if (i == PhoneBook_number) System.out.println(name+"이 없습니다.");
        }




    }
}
