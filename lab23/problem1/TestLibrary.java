package lab23.problem1;

public class TestLibrary {
    public static void main(String[] args) {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, 310, "Fantasy");
        Book book2 = new Book("1984", "George Orwell", 1949, 328, "Dystopia");
        Book book3 = new Book("Clean Code", "Robert C. Martin", 2008, 431, "Programming");

        LibraryItem[] library = { book1, book2, book3 };

        System.out.println("Library Collection");
        for (LibraryItem item : library) {
            System.out.println(item);
        }
    }
}