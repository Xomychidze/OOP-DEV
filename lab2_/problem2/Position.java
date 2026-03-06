public class Position {
    private int row; // 0-7
    private int col; // 0-7

    public Position(int row, int col) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            throw new IllegalArgumentException("Position must be within 0-7 range.");
        }
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    @Override
    public String toString() {
        char colChar = (char) ('a' + col);
        return "" + colChar + (row + 1);
    }
}
