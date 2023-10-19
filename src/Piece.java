package src;

import javax.swing.*;

public abstract class Piece {
    protected ChessColor color;

    private Square square;

    public Piece(ChessColor color) {
        this.color = color;
    }

    public abstract boolean isValidMove(Square start, Square end, Board board);

    public abstract String getPieceName();

    public void setSquare(Square square){
        this.square = square;
    }
    public Square getSquare(){
        return this.square;
    }
    public ChessColor getColor() {
        return this.color;
    }
}
