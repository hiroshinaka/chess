package src;

import javax.swing.*;

public class Knight extends Piece {

    public Knight(ChessColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Square start, Square end) {
        return false;
    }

    @Override
    public String getPieceName(){
        return "Knight";
    }
}
