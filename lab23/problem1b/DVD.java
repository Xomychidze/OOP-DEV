public class DVD extends LibraryItem {
    private int durationMinutes;
    private String genre;

    public DVD(String title, String director, int publicationYear, int durationMinutes, String genre) {
        super(title, director, publicationYear);
        this.durationMinutes = durationMinutes;
        this.genre = genre;
    }

    public int getDurationMinutes() { return durationMinutes; }
    public String getGenre() { return genre; }

    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String getItemType() {
        return "DVD";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Duration: %d min, Genre: %s", durationMinutes, genre);
    }
}
