package ramStudio.piecies;

import ramStudio.chessGame.Board;
import ramStudio.enums.Colors;

public class Horse extends ChessPiece{
    public Horse(Colors color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, int row, int column, int toRow, int toColumn) {
        int rowDiff = Math.abs(toRow - row);
        int colDiff = Math.abs(toColumn - column);

        if (!((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)))
            return false;

        ChessPiece target = board.getPiece(toRow, toColumn);
        return target == null || target.getColor() != color;
    }

    @Override
    public String getSymbol() {
        return color == Colors.White ? "H" : "h";
    }
}
