import java.util.Scanner;

class Consert {
    Scanner sc = new Scanner(System.in);
    private String[][] seat = new String[3][10];


    Consert() {
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                seat[i][j] = "---";
            }
        }

    }

    void reservation(int level) {
        int seat_level = level - 1;
        if (seat_level == 0) {
            System.out.printf("S>> ");
        }
        if (seat_level == 1) {
            System.out.printf("A>> ");
        }
        if (seat_level == 2) {
            System.out.printf("B>> ");
        }
        for (int i = 0; i < seat[level - 1].length; i++) {

            System.out.printf(seat[level - 1][i] + "  ");
        }
        System.out.println();

        System.out.printf("이름>>");
        String name = sc.next();
        System.out.printf("번호>>");
        int seat_number = sc.nextInt();

        seat[seat_level][seat_number - 1] = name;


    }

    void show() {
        System.out.printf("S>> ");
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                System.out.printf(seat[i][j] + " ");
            }
            System.out.println();
            if (i == 0) {
                System.out.printf("A>> ");
            }
            if (i == 1) {
                System.out.printf("B>> ");
            }

        }
        System.out.println("<<< 조회를 완료하였습니다.>>>");

    }

    void cancel() {
        int check = 0;

        System.out.printf("좌석 S:1, A:2, B:3>>");
        int seat_level = sc.nextInt();

        while (true) {
            if (seat_level >= 4 || seat_level <= 0) {
                System.out.printf("다시 입력해주세요>>");
                seat_level = sc.nextInt();
            }
            else break;
        }


        if (seat_level == 1) {
            System.out.printf("S>> ");
        }
        if (seat_level == 2) {
            System.out.printf("A>> ");
        }
        if (seat_level == 3) {
            System.out.printf("B>> ");
        }
        for (int i = 0; i < seat[seat_level - 1].length; i++) {

            System.out.printf(seat[seat_level - 1][i] + "  ");
        }
        System.out.println();
        System.out.printf("이름>>");
        String name = sc.next();

        int count = 0;

        for (int j = 0; j < seat[seat_level - 1].length; j++) {

            if (seat[seat_level - 1][j].equals(name)) {
                seat[seat_level - 1][j] = "---";
                count++;

            }
            if (j == 9 & count == 0) {
                System.out.printf("없는 이름입니다. 다시 입력해주세요>>");
                name = sc.next();
                j = -1;

            }

        }


    }

}

public class num_12 {
    public static void main(String[] args) {
        System.out.println("명품 콘서트홀 예약 시스템입니다.");

        Consert c = new Consert();

        boolean start = true;
        while (start) {
            System.out.print("예약 : 1, 조회:2, 취소:3, 끝내기:4>>");
            Scanner sc = new Scanner(System.in);

            int menu = sc.nextInt();

            while(true) {
                if (!(menu == 1 || menu == 2 || menu == 3 || menu == 4)) {
                    System.out.printf("다시 입력해주세요>>");
                    menu = sc.nextInt();
                }
                else break;

            }

            switch (menu) {
                case 1:

                    System.out.printf("좌석 구분 S(1), A(2), B(3) >> ");
                    int seat_Number = sc.nextInt();
                    c.reservation(seat_Number);
                    break;

                case 2:
                    c.show();

                    break;
                case 3:
                    c.cancel();

                    break;
                case 4:
                    start = false;
                    break;
            }

        }

    }
}
