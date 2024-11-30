package ramStudio.piecies;

import ramStudio.chessGame.Board;
import ramStudio.extensions.Colors;

public abstract class ChessPiece {
    protected Colors Color;
    protected boolean Check;

    protected ChessPiece(Colors color) {
        Color = color;
        Check = true;
    }

    public Colors getColor() {
        return this.Color;
    }

    public boolean getCheck(){
        return Check;
    }

    public void setCheck(){
        Check = false;
    }

    public abstract boolean canMove(Board board, int row, int column, int toRow, int toColumn);

    //public abstract List<int[]> getPossibleMoves(Board board); - на мой взгляд такой подход лучше.

    public abstract String getSymbol();
}
