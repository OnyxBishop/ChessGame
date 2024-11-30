package ramStudio.piecies;

import ramStudio.chessGame.Board;
import ramStudio.enums.Colors;

public abstract class ChessPiece {
    protected Colors color;
    protected boolean check;

    protected ChessPiece(Colors color) {
        this.color = color;
        check = true;
    }

    public Colors getColor() {
        return this.color;
    }

    public boolean getCheck(){
        return check;
    }

    public void setCheck(){
        check = false;
    }

    public abstract boolean canMove(Board board, int row, int column, int toRow, int toColumn);

    //public abstract List<int[]> getPossibleMoves(Board board); - на мой взгляд такой подход лучше.

    public abstract String getSymbol();
}
