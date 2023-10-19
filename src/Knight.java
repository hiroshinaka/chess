package src;

import javax.swing.*;

public class Knight extends Piece {

    public Knight(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Square start, Square end, Board board) {
        System.out.println("Validating move for knight from (" + start.getRow() + "," + start.getCol() + ") to (" + end.getRow() + "," + end.getCol() + ")");
        int rowDifference = Math.abs(end.getRow() - start.getRow());
        int colDifference = Math.abs(end.getCol() - start.getCol());
        // Check the two possible L-shaped moves:
        return (rowDifference == 2 && colDifference == 1) || (rowDifference == 1 && colDifference == 2);
    }

    @Override
    public String getPieceName(){
        return "Knight";
    }
}
