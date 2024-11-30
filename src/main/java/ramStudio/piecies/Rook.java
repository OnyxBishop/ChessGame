package ramStudio.piecies;

import ramStudio.chessGame.Board;
import ramStudio.extensions.Colors;

public class Rook extends ChessPiece {
    public Rook(Colors color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, int row, int column, int toRow, int toColumn) {
        if (row != toRow && column != toColumn)
            return false;

        int stepRow = Integer.compare(toRow, row);
        int stepColumn = Integer.compare(toColumn, column);

        int currentRow = row + stepRow;
        int currentColumn = column + stepColumn;

        while (currentRow != toRow || currentColumn != toColumn) {
            if (board.getPiece(currentRow, currentColumn) != null)
                return false;

            currentRow += stepRow;
            currentColumn += stepColumn;
        }

        var enemy = board.getPiece(toRow, toColumn);

        return enemy == null || enemy.getColor() != Color;
    }

    @Override
    public String getSymbol() {
        return Color == Colors.White ? "R" : "r";
    }
}
