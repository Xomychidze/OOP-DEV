public class Magazine extends LibraryItem {
    private int issueNumber;
    private String category;

    public Magazine(String title, String publisher, int publicationYear, int issueNumber, String category) {
        super(title, publisher, publicationYear);
        this.issueNumber = issueNumber;
        this.category = category;
    }

    public int getIssueNumber() { return issueNumber; }
    public String getCategory() { return category; }

    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String getItemType() {
        return "Magazine";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Issue #%d, Category: %s", issueNumber, category);
    }
}
