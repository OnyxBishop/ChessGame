package ramStudio.chessGame;

import ramStudio.extensions.Colors;
import ramStudio.piecies.*;

public class Board {
    private final int sizeX = 8;

    private Colors currentPlayer;
    private ChessPiece[][] grid;

    public Board() {
        grid = new ChessPiece[8][8];
        currentPlayer = Colors.White;
        initialiseGrid();
    }

    public void draw() {
        for (int row = 7; row > -1; row--) {
            System.out.print((row + 1) + "  ");

            for (int column = 0; column < sizeX; column++) {
                if (grid[row][column] != null)
                    System.out.print(grid[row][column].getSymbol() + " ");
                else
                    System.out.print(". ");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println("  a b c d e f g h");
    }

    public boolean moveToPosition(int row, int column, int toRow, int toColumn) {
        if (!checkPosition(row) || !checkPosition(column))
            return false;

        if (!currentPlayer.equals(grid[row][column].getColor()))
            return false;

        if (!grid[row][column].canMove(this, row, column, toRow, toColumn))
            return false;

        if (grid[row][column] instanceof Rook && grid[row][column] instanceof King)
            if (!grid[row][column].getCheck())
                grid[row][column].setCheck();

        grid[toRow][toColumn] = grid[row][column];
        grid[row][column] = null;
        setPlayer();

        return true;
    }

    public boolean castling0() {
        /*var rook = grid[0][0];
        var king = grid[0][4];

        if (rook == null || king == null)
            return false;

        if (rook.getSymbol().equals("R") && king.getSymbol().equals("K") &&
                grid[0][1] == null && grid[0][2] == null && grid[0][3] == null) {
            if (rook.getColor().equals(Colors.White) && king.getColor().equals(Colors.White) &&
                    rook.getCheck() && king.getCheck()
            )
        }*/
        return false;
    }

    public boolean castling7() {
        return false;
    }

    public ChessPiece getPiece(int row, int column) {
        if (!checkPosition(row) || !checkPosition(column))
            throw new IllegalArgumentException();

        if (grid[row][column] != null)
            return grid[row][column];

        return null;
    }

    private void initialiseGrid() {
        for (int i = 0; i < 8; i++) {
            grid[1][i] = new Pawn(Colors.White);
            grid[6][i] = new Pawn(Colors.Black);
        }

        grid[0][0] = new Rook(Colors.White);
        grid[0][1] = new Horse(Colors.White);
        grid[0][2] = new Bishop(Colors.White);
        grid[0][3] = new Queen(Colors.White);
        grid[0][4] = new King(Colors.White);
        grid[0][5] = new Bishop(Colors.White);
        grid[0][6] = new Horse(Colors.White);
        grid[0][7] = new Rook(Colors.White);

        grid[7][0] = new Rook(Colors.Black);
        grid[7][1] = new Horse(Colors.Black);
        grid[7][2] = new Bishop(Colors.Black);
        grid[7][3] = new Queen(Colors.Black);
        grid[7][4] = new King(Colors.Black);
        grid[7][5] = new Bishop(Colors.Black);
        grid[7][6] = new Horse(Colors.Black);
        grid[7][7] = new Rook(Colors.Black);
    }

    private void setPlayer() {
        currentPlayer = currentPlayer.equals(Colors.White) ? Colors.Black : Colors.White;
    }

    private boolean checkPosition(int position) {
        return position >= 0 && position <= 7;
    }
}
