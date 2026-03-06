public class Knight extends Piece {
    public Knight(Position position, String color) {
        super(position, color);
    }

    @Override
    public boolean isLegalMove(Position target) {
        // Knight moves in an L-shape: (2,1) or (1,2)
        int rowDiff = Math.abs(target.getRow() - position.getRow());
        int colDiff = Math.abs(target.getCol() - position.getCol());
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
}
