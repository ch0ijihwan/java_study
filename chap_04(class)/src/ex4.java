public class ex4 {
    public static class Book {
        String title;
        String author;

        public Book(String t) {
            title = t;
            author = "작자미상";
        }

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Book littlePrice = new Book("어린왕자","생텍쥐페리");

        Book loveStory = new Book("춘향전");
        System.out.println((littlePrice.title + " " + littlePrice.author));
        System.out.println((loveStory.title + " " + loveStory.author));
    }
}
