public class Bishop extends Piece {
    public Bishop(Position position, String color) {
        super(position, color);
    }

    @Override
    public boolean isLegalMove(Position target) {
        // Bishop moves diagonally: |rowDiff| == |colDiff|
        int rowDiff = Math.abs(target.getRow() - position.getRow());
        int colDiff = Math.abs(target.getCol() - position.getCol());
        return rowDiff == colDiff && rowDiff != 0;
    }
}
