public class Queen extends Piece {
    public Queen(Position position, String color) {
        super(position, color);
    }

    @Override
    public boolean isLegalMove(Position target) {
        // Queen combines Rook + Bishop movement
        int rowDiff = Math.abs(target.getRow() - position.getRow());
        int colDiff = Math.abs(target.getCol() - position.getCol());

        boolean sameRow = position.getRow() == target.getRow();
        boolean sameCol = position.getCol() == target.getCol();
        boolean diagonal = rowDiff == colDiff && rowDiff != 0;

        return (sameRow || sameCol || diagonal) && !(rowDiff == 0 && colDiff == 0);
    }
}
