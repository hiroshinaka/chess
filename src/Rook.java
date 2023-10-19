package src;

import javax.swing.*;

public class Rook extends Piece{
    public Rook(ChessColor color) {
        super(color);
    }
    @Override
    public boolean isValidMove(Square start, Square end, Board board) {
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
        // Not a valid Rook move
        return false;
    }


    @Override
    public String getPieceName(){
        return "Rook";
    }
}
