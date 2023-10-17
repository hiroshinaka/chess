package src;

import javax.swing.*;

public class Bishop extends Piece{
    public Bishop(ChessColor color){
        super(color);
    }

    @Override
    public boolean isValidMove(Square start, Square end) {
        return false;
    }

    @Override
    public String getPieceName(){
        return "Bishop";
    }
}
