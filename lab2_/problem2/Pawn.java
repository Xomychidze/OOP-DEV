public class Pawn extends Piece {
    private boolean hasMoved;

    public Pawn(Position position, String color) {
        super(position, color);
        this.hasMoved = false;
    }

    @Override
    public boolean isLegalMove(Position target) {
        int rowDiff = target.getRow() - position.getRow();
        int colDiff = Math.abs(target.getCol() - position.getCol());

        // White moves up (increasing row), black moves down (decreasing row)
        int direction = color.equals("white") ? 1 : -1;

        // Standard 1-square forward move (no capture)
        if (colDiff == 0 && rowDiff == direction) {
            return true;
        }

        // First move: 2 squares forward
        if (!hasMoved && colDiff == 0 && rowDiff == 2 * direction) {
            return true;
        }

        // Diagonal capture
        if (colDiff == 1 && rowDiff == direction) {
            return true; // Simplified: doesn't check if there's actually an enemy piece
        }

        return false;
    }

    public void markAsMoved() {
        this.hasMoved = true;
    }
}
