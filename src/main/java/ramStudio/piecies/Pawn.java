package ramStudio.piecies;

import ramStudio.chessGame.Board;
import ramStudio.enums.Colors;

public class Pawn extends ChessPiece {
    private final int startRow;
    private final int direction;

    public Pawn(Colors color) {
        super(color);
        direction = this.color == Colors.White ? 1 : -1;
        startRow = this.color == Colors.White ? 1 : 6;
    }

    @Override
    public boolean canMove(Board board, int row, int column, int toRow, int toColumn) {
        if (toColumn == column && toRow == row + direction && board.getPiece(toRow, toColumn) == null) {
            return true;
        }

        if (row == startRow && toColumn == column && toRow == row + 2 * direction) {
            if (board.getPiece(toRow, toColumn) == null) {
                return true;
            }
        }

        if (Math.abs(toColumn - column) == 1 && toRow == row + direction) {
            ChessPiece target = board.getPiece(toRow, toColumn);
            return target != null && target.getColor() != color;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return color == Colors.White ? "P" : "p";
    }
}
