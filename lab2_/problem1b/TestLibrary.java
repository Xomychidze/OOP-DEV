public class TestLibrary {
    public static void main(String[] args) {
        LibraryItem book = new Book("Clean Code", "Robert Martin", 2008, 431, "978-0132350884");
        LibraryItem dvd = new DVD("Inception", "Christopher Nolan", 2010, 148, "Sci-Fi");
        LibraryItem magazine = new Magazine("National Geographic", "NatGeo Society", 2024, 312, "Science");

        System.out.println("=== Library System ===");
        System.out.println(book);
        System.out.println(dvd);
        System.out.println(magazine);
    }
}
