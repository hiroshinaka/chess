package src;

import javax.swing.*;

public class Queen extends Piece{
    public Queen(ChessColor color){
        super(color);
    }

    @Override
    public boolean isValidMove(Square start, Square end) {
        return false;
    }

    @Override
    public String getPieceName(){
        return "Queen";
    }
}
