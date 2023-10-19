package src;

import javax.swing.*;

public class Bishop extends Piece{
    public Bishop(ChessColor color){
        super(color);
    }

    @Override
    public boolean isValidMove(Square start, Square end, Board board) {
        System.out.println("Validating move for bishop from (" + start.getRow() + "," + start.getCol() + ") to (" + end.getRow() + "," + end.getCol() + ")");

        int rowDiff = end.getRow() - start.getRow();
        int colDiff = end.getCol() - start.getCol();

        if (Math.abs(rowDiff) != Math.abs(colDiff)) {
            return false;  // Not moving diagonally
        }

        // Determine the direction of movement
        int rowDirection = (rowDiff > 0) ? 1 : -1;
        int colDirection = (colDiff > 0) ? 1 : -1;

        int currentRow = start.getRow() + rowDirection;
        int currentCol = start.getCol() + colDirection;

        while (currentRow != end.getRow() || currentCol != end.getCol()) {
            // Check if the square in the path is empty
            if (board.getSquare(currentRow, currentCol).getPiece() != null) {
                return false;  // There's a piece blocking the bishop's path
            }

            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return true;
    }


    @Override
    public String getPieceName(){
        return "Bishop";
    }
}
