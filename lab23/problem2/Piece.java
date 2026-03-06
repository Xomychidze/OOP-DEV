public abstract class Piece {
    protected Position position;
    protected String color; // "white" or "black"

    public Piece(Position position, String color) {
        this.position = position;
        this.color = color;
    }

    public Position getPosition() { return position; }
    public String getColor() { return color; }
    public void setPosition(Position position) { this.position = position; }

    public abstract boolean isLegalMove(Position target);

    @Override
    public String toString() {
        return String.format("%s %s at %s", color, getClass().getSimpleName(), position);
    }
}
