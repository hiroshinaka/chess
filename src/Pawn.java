package src;

import javax.swing.*;

public class Pawn extends Piece{
    public Pawn(ChessColor color){
        super(color);
    }
    @Override
    public boolean isValidMove(Square start, Square end) {
        System.out.println("Validating move for pawn from (" + start.getRow() + "," + start.getCol() + ") to (" + end.getRow() + "," + end.getCol() + ")");

        int direction = (this.getColor() == ChessColor.WHITE) ? -1 :1;

        if (start.getCol() == end.getCol() && start.getRow() + direction == end.getRow()) {
            return end.getPiece() == null;
        }
        if (Math.abs(start.getCol() - end.getCol()) == 1 && end.getRow() == start.getRow() + direction){
            return end.getPiece() != null && end.getPiece().getColor() != this.getColor();
        }

        return false;
    }

    @Override
    public String getPieceName(){
        return "Pawn";
    }


}
