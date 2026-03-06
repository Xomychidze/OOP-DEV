public class Book extends LibraryItem {
    private int numberOfPages;
    private String isbn;

    public Book(String title, String author, int publicationYear, int numberOfPages, String isbn) {
        super(title, author, publicationYear);
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
    }

    public int getNumberOfPages() { return numberOfPages; }
    public String getIsbn() { return isbn; }

    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Pages: %d, ISBN: %s", numberOfPages, isbn);
    }
}
