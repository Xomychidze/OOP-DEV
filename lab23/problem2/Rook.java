public class Rook extends Piece {
    public Rook(Position position, String color) {
        super(position, color);
    }

    @Override
    public boolean isLegalMove(Position target) {
        // Rook moves horizontally or vertically (row or col must stay the same)
        return position.getRow() == target.getRow() || position.getCol() == target.getCol();
    }
}
