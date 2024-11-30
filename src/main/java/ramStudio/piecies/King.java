package ramStudio.piecies;

import ramStudio.chessGame.Board;
import ramStudio.extensions.Colors;

public class King extends ChessPiece {
    public King(Colors color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, int row, int column, int toRow, int toColumn) {
        int rowDiff = Math.abs(toRow - row);
        int colDiff = Math.abs(toColumn - column);

        if (rowDiff <= 1 && colDiff <= 1) {
            ChessPiece target = board.getPiece(toRow, toColumn);
            return target == null || target.getColor() != Color;
        }

        return false;
    }
    @Override
    public String getSymbol() {
        return Color == Colors.White ? "K" : "k";
    }
}
