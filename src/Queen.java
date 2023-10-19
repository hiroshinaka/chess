package src;

import javax.swing.*;

public class Queen extends Piece{
    public Queen(ChessColor color){
        super(color);
    }

    @Override
    public boolean isValidMove(Square start, Square end, Board board) {
        System.out.println("Validating move for queen from (" + start.getRow() + "," + start.getCol() + ") to (" + end.getRow() + "," + end.getCol() + ")");
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();

        // Vertical movement
        if (startCol == endCol && startRow != endRow) {
            int step = (startRow < endRow) ? 1 : -1;  // Determine if moving up or down
            for (int r = startRow + step; r != endRow; r += step) {
                if (board.getSquare(r, startCol).getPiece() != null) {
                    return false;  // There's a piece blocking the way
                }
            }
            return true;
        }
        // Horizontal movement
        else if (startRow == endRow && startCol != endCol) {
            int step = (startCol < endCol) ? 1 : -1;  // Determine if moving left or right
            for (int c = startCol + step; c != endCol; c += step) {
                if (board.getSquare(startRow, c).getPiece() != null) {
                    return false;  // There's a piece blocking the way
                }
            }
            return true;
        }

        // Diagonal movement
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

        while (currentRow != end.getRow() && currentCol != end.getCol()) {
            // Check if the square in the path is empty
            if (board.getSquare(currentRow, currentCol).getPiece() != null) {
                return false;  // There's a piece blocking the queen's path
            }

            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return true;  // Valid diagonal move for the queen

    }

    @Override
    public String getPieceName(){
        return "Queen";
    }
}
