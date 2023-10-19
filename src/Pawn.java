package src;

import javax.swing.*;

public class Pawn extends Piece{
    public Pawn(ChessColor color){
        super(color);
    }
    @Override
    public boolean isValidMove(Square start, Square end, Board board) {
        System.out.println("Validating move for pawn from (" + start.getRow() + "," + start.getCol() + ") to (" + end.getRow() + "," + end.getCol() + ")");
        //Validate first move of pawn to 2 spaces
        if (start.getRow() == 1 && end.getRow() == 3 && start.getCol() == end.getCol()){
            return board.getSquare(2, start.getCol()).getPiece() == null; // Check if the square in between is empty
        } else if (start.getRow() == 6 && end.getRow() == 4 && start.getCol() == end.getCol()){
            return board.getSquare(5, start.getCol()).getPiece() == null; // Check if the square in between is empty
        }

        //Validate normal move of pawn
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
