package src;

import javax.swing.*;

public class Rook extends Piece{
    public Rook(ChessColor color) {
        super(color);
    }
    @Override
    public boolean isValidMove(Square start, Square end) {
        // Define rook's valid move logic
        return false; // Placeholder
    }

    @Override
    public String getPieceName(){
        return "Rook";
    }
}
