package lab23.problem2;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private boolean whiteTurn;
    private Scanner scanner;

    public ChessGame() {
        board = new Board();
        whiteTurn = true;
        scanner = new Scanner(System.in);
    }

    private Position parsePosition(String s) {
        if (s.length() != 2) return null;
        int col = s.charAt(0) - 'a';
        int row = s.charAt(1) - '1';
        Position pos = new Position(col, row);
        return pos.isValid() ? pos : null;
    }

    public void start() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     WELCOME TO CHESS!        ║");
        System.out.println("║  Type moves like: e2 e4      ║");
        System.out.println("║  Type 'quit' to exit         ║");
        System.out.println("╚══════════════════════════════╝");

        while (true) {
            board.draw();
            String currentPlayer = whiteTurn ? "White" : "Black";
            System.out.print(currentPlayer + "'s move: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                System.out.println("Invalid format. Example: e2 e4");
                continue;
            }

            Position from = parsePosition(parts[0]);
            Position to   = parsePosition(parts[1]);

            if (from == null || to == null) {
                System.out.println("Invalid position. Columns: a-h, Rows: 1-8");
                continue;
            }

            Piece piece = board.getPiece(from);

            if (piece == null) {
                System.out.println("No piece at " + from);
                continue;
            }
            if (piece.isWhite() != whiteTurn) {
                System.out.println("That's not your piece!");
                continue;
            }

            boolean moved = board.movePiece(from, to);
            if (!moved) {
                System.out.println("Illegal move for " + piece.getClass().getSimpleName() + "!");
                continue;
            }

            if (board.isInCheck(!whiteTurn)) {
                System.out.println("CHECK!");
            }

            System.out.println("Moved " + piece.getClass().getSimpleName()
                    + " from " + from + " to " + to);

            whiteTurn = !whiteTurn;
        }
    }

    public static void main(String[] args) {
        new ChessGame().start();
    }
}


class Position {
    private int col, row;

    Position(int col, int row) { this.col = col; this.row = row; }

    int getCol() { return col; }
    int getRow() { return row; }

    boolean isValid() { return col >= 0 && col < 8 && row >= 0 && row < 8; }

    @Override
    public String toString() { return "" + (char)('a' + col) + (row + 1); }
}


abstract class Piece {
    protected Position position;
    protected boolean isWhite;

    Piece(Position position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }

    Position getPosition() { return position; }
    void setPosition(Position position) { this.position = position; }
    boolean isWhite() { return isWhite; }

    abstract boolean isLegalMove(Position to, Board board);
    abstract String getSymbol();

    protected boolean isFriendlyPiece(Position to, Board board) {
        Piece target = board.getPiece(to);
        return target != null && target.isWhite() == this.isWhite;
    }

    protected boolean isPathClear(Position to, Board board) {
        int dCol = Integer.signum(to.getCol() - position.getCol());
        int dRow = Integer.signum(to.getRow() - position.getRow());
        int col = position.getCol() + dCol;
        int row = position.getRow() + dRow;
        while (col != to.getCol() || row != to.getRow()) {
            if (board.getPiece(new Position(col, row)) != null) return false;
            col += dCol;
            row += dRow;
        }
        return true;
    }
}

class Rook extends Piece {
    Rook(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    boolean isLegalMove(Position to, Board board) {
        if (!to.isValid() || isFriendlyPiece(to, board)) return false;
        int dCol = Math.abs(to.getCol() - position.getCol());
        int dRow = Math.abs(to.getRow() - position.getRow());
        if (dCol != 0 && dRow != 0) return false;
        return isPathClear(to, board);
    }

    @Override String getSymbol() { return isWhite ? "R" : "r"; }
}

class Knight extends Piece {
    Knight(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    boolean isLegalMove(Position to, Board board) {
        if (!to.isValid() || isFriendlyPiece(to, board)) return false;
        int dCol = Math.abs(to.getCol() - position.getCol());
        int dRow = Math.abs(to.getRow() - position.getRow());
        return (dCol == 2 && dRow == 1) || (dCol == 1 && dRow == 2);
    }

    @Override String getSymbol() { return isWhite ? "N" : "n"; }
}

class Bishop extends Piece {
    Bishop(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    boolean isLegalMove(Position to, Board board) {
        if (!to.isValid() || isFriendlyPiece(to, board)) return false;
        int dCol = Math.abs(to.getCol() - position.getCol());
        int dRow = Math.abs(to.getRow() - position.getRow());
        if (dCol != dRow) return false;
        return isPathClear(to, board);
    }

    @Override String getSymbol() { return isWhite ? "B" : "b"; }
}

class Queen extends Piece {
    Queen(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    boolean isLegalMove(Position to, Board board) {
        if (!to.isValid() || isFriendlyPiece(to, board)) return false;
        int dCol = Math.abs(to.getCol() - position.getCol());
        int dRow = Math.abs(to.getRow() - position.getRow());
        boolean straight = (dCol == 0 || dRow == 0);
        boolean diagonal = (dCol == dRow);
        if (!straight && !diagonal) return false;
        return isPathClear(to, board);
    }

    @Override String getSymbol() { return isWhite ? "Q" : "q"; }
}

class King extends Piece {
    King(Position position, boolean isWhite) { super(position, isWhite); }

    @Override
    boolean isLegalMove(Position to, Board board) {
        if (!to.isValid() || isFriendlyPiece(to, board)) return false;
        int dCol = Math.abs(to.getCol() - position.getCol());
        int dRow = Math.abs(to.getRow() - position.getRow());
        return dCol <= 1 && dRow <= 1 && (dCol + dRow > 0);
    }

    @Override String getSymbol() { return isWhite ? "K" : "k"; }
}

class Pawn extends Piece {
    private boolean hasMoved = false;

    Pawn(Position position, boolean isWhite) { super(position, isWhite); }

    void setHasMoved() { this.hasMoved = true; }

    @Override
    boolean isLegalMove(Position to, Board board) {
        if (!to.isValid() || isFriendlyPiece(to, board)) return false;
        int direction = isWhite ? 1 : -1;
        int dCol = to.getCol() - position.getCol();
        int dRow = to.getRow() - position.getRow();

        if (dCol == 0 && dRow == direction)
            return board.getPiece(to) == null;

        if (dCol == 0 && dRow == 2 * direction && !hasMoved) {
            Position middle = new Position(position.getCol(), position.getRow() + direction);
            return board.getPiece(to) == null && board.getPiece(middle) == null;
        }

        if (Math.abs(dCol) == 1 && dRow == direction)
            return board.getPiece(to) != null && board.getPiece(to).isWhite() != this.isWhite;

        return false;
    }

    @Override String getSymbol() { return isWhite ? "P" : "p"; }
}

class Board {
    private Piece[][] grid = new Piece[8][8];

    Board() { setupPieces(); }

    private void setupPieces() {
        grid[7][0] = new Rook(new Position(0, 7), false);
        grid[7][1] = new Knight(new Position(1, 7), false);
        grid[7][2] = new Bishop(new Position(2, 7), false);
        grid[7][3] = new Queen(new Position(3, 7), false);
        grid[7][4] = new King(new Position(4, 7), false);
        grid[7][5] = new Bishop(new Position(5, 7), false);
        grid[7][6] = new Knight(new Position(6, 7), false);
        grid[7][7] = new Rook(new Position(7, 7), false);
        for (int c = 0; c < 8; c++) grid[6][c] = new Pawn(new Position(c, 6), false);

        grid[0][0] = new Rook(new Position(0, 0), true);
        grid[0][1] = new Knight(new Position(1, 0), true);
        grid[0][2] = new Bishop(new Position(2, 0), true);
        grid[0][3] = new Queen(new Position(3, 0), true);
        grid[0][4] = new King(new Position(4, 0), true);
        grid[0][5] = new Bishop(new Position(5, 0), true);
        grid[0][6] = new Knight(new Position(6, 0), true);
        grid[0][7] = new Rook(new Position(7, 0), true);
        for (int c = 0; c < 8; c++) grid[1][c] = new Pawn(new Position(c, 1), true);
    }

    Piece getPiece(Position pos) { return grid[pos.getRow()][pos.getCol()]; }

    void setPiece(Position pos, Piece piece) { grid[pos.getRow()][pos.getCol()] = piece; }

    boolean movePiece(Position from, Position to) {
        Piece piece = getPiece(from);
        if (piece == null || !piece.isLegalMove(to, this)) return false;
        if (piece instanceof Pawn) ((Pawn) piece).setHasMoved();
        setPiece(to, piece);
        setPiece(from, null);
        piece.setPosition(to);
        return true;
    }

    boolean isInCheck(boolean whiteKing) {
        Position kingPos = null;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                if (p instanceof King && p.isWhite() == whiteKing)
                    kingPos = new Position(c, r);
            }
        if (kingPos == null) return true;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                if (p != null && p.isWhite() != whiteKing && p.isLegalMove(kingPos, this))
                    return true;
            }
        return false;
    }

    void draw() {
        System.out.println("\n    a   b   c   d   e   f   g   h  ");
        System.out.println("  ┌───┬───┬───┬───┬───┬───┬───┬───┐");
        for (int row = 7; row >= 0; row--) {
            System.out.print((row + 1) + " │");
            for (int col = 0; col < 8; col++) {
                Piece piece = grid[row][col];
                String symbol = (piece == null) ? " " : piece.getSymbol();
                System.out.print(" " + symbol + " │");
            }
            System.out.println(" " + (row + 1));
            if (row > 0)
                System.out.println("  ├───┼───┼───┼───┼───┼───┼───┼───┤");
        }
        System.out.println("  └───┴───┴───┴───┴───┴───┴───┴───┘");
        System.out.println("    a   b   c   d   e   f   g   h  \n");
    }
}