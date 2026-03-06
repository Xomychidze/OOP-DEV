public class TestChess {
    public static void main(String[] args) {
        System.out.println("=== Chess Pieces - Legal Move Tests ===\n");

        // Rook at d4 (row=3, col=3)
        Piece rook = new Rook(new Position(3, 3), "white");
        System.out.println(rook);
        System.out.println("  Move to d7 (same col, legal):   " + rook.isLegalMove(new Position(6, 3)));  // true
        System.out.println("  Move to h4 (same row, legal):   " + rook.isLegalMove(new Position(3, 7)));  // true
        System.out.println("  Move to e5 (diagonal, illegal): " + rook.isLegalMove(new Position(4, 4)));  // false

        System.out.println();

        // Bishop at c1 (row=0, col=2)
        Piece bishop = new Bishop(new Position(0, 2), "white");
        System.out.println(bishop);
        System.out.println("  Move to f4 (diagonal, legal):   " + bishop.isLegalMove(new Position(3, 5)));  // true
        System.out.println("  Move to a3 (diagonal, legal):   " + bishop.isLegalMove(new Position(2, 0)));  // true
        System.out.println("  Move to c4 (straight, illegal): " + bishop.isLegalMove(new Position(3, 2)));  // false

        System.out.println();

        // Queen at d1 (row=0, col=3)
        Piece queen = new Queen(new Position(0, 3), "white");
        System.out.println(queen);
        System.out.println("  Move to d5 (vertical, legal):   " + queen.isLegalMove(new Position(4, 3)));  // true
        System.out.println("  Move to h5 (diagonal, legal):   " + queen.isLegalMove(new Position(4, 7)));  // true
        System.out.println("  Move to b3 (L-shape, illegal):  " + queen.isLegalMove(new Position(2, 1)));  // false

        System.out.println();

        // Knight at g1 (row=0, col=6)
        Piece knight = new Knight(new Position(0, 6), "white");
        System.out.println(knight);
        System.out.println("  Move to f3 (L-shape, legal):    " + knight.isLegalMove(new Position(2, 5)));  // true
        System.out.println("  Move to h3 (L-shape, legal):    " + knight.isLegalMove(new Position(2, 7)));  // true
        System.out.println("  Move to g3 (straight, illegal): " + knight.isLegalMove(new Position(2, 6)));  // false

        System.out.println();

        // King at e1 (row=0, col=4)
        Piece king = new King(new Position(0, 4), "white");
        System.out.println(king);
        System.out.println("  Move to e2 (1 up, legal):       " + king.isLegalMove(new Position(1, 4)));   // true
        System.out.println("  Move to d2 (diag, legal):       " + king.isLegalMove(new Position(1, 3)));   // true
        System.out.println("  Move to e3 (2 up, illegal):     " + king.isLegalMove(new Position(2, 4)));   // false

        System.out.println();

        // Pawn at e2 (row=1, col=4), white
        Pawn pawn = new Pawn(new Position(1, 4), "white");
        System.out.println(pawn);
        System.out.println("  Move to e3 (1 forward, legal):  " + pawn.isLegalMove(new Position(2, 4)));   // true
        System.out.println("  Move to e4 (2 forward, legal):  " + pawn.isLegalMove(new Position(3, 4)));   // true
        System.out.println("  Move to d3 (capture, legal):    " + pawn.isLegalMove(new Position(2, 3)));   // true
        System.out.println("  Move to e5 (too far, illegal):  " + pawn.isLegalMove(new Position(4, 4)));   // false
    }
}
