package lab23.problem1;


public class Book extends LibraryItem {
    private int numberOfPages;
    private String genre;

    public Book(String title, String author, int year, int numberOfPages, String genre) {
        super(title, author, year);
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public int getNumberOfPages() { return numberOfPages; }
    public String getGenre() { return genre; }

    public void setNumberOfPages(int pages) { this.numberOfPages = pages; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Pages: %d | Genre: %s",
                numberOfPages, genre);
    }
}

