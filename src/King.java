package src;

import javax.swing.*;

public class King extends Piece{
    public King(ChessColor color){
        super(color);
    }
    @Override
    public boolean isValidMove(Square start, Square end, Board board) {
        System.out.println("Validating move for king from (" + start.getRow() + "," + start.getCol() + ") to (" + end.getRow() + "," + end.getCol() + ")");
        int direction = (this.getColor() == ChessColor.WHITE) ? -1 :1;

        //Diagonal movement
        if (Math.abs(start.getRow() - end.getRow()) == 1 && Math.abs(start.getCol() - end.getCol()) == 1) {
            return end.getPiece() == null || end.getPiece().getColor() != this.getColor();
        }
        //Vertical movement
        if (start.getCol() == end.getCol() && start.getRow() + direction == end.getRow()) {
            return end.getPiece() == null;
        }
        //Horizontal movement
        if (start.getRow() == end.getRow() + direction && start.getCol() == end.getCol()) {
            return end.getPiece() == null;
        }

        return false;
    }

    @Override
    public String getPieceName(){
        return "King";
    }
}
