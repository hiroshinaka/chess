package src;

import javax.swing.*;

public class King extends Piece{
    public King(ChessColor color){
        super(color);
    }
    @Override
    public boolean isValidMove(Square start, Square end) {
        return false;
    }

    @Override
    public String getPieceName(){
        return "King";
    }
}
