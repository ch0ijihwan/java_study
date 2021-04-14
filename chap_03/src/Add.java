public class Add {
    public static void main(String[] args) {

        int add = 0;
        for (int i = 0; i < args.length; i++) {
            if (isInteger(args[i])) {
                add += Integer.parseInt(args[i]);
            }
        }
        System.out.println(add);
    }
    public static boolean isInteger(String a) { //정수형인지 판별

        try {
            Integer.parseInt(a);

            return true;

        } catch (NumberFormatException e) {
            return false;
        }


    }
}
