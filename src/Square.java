package src;

public class Square {

    private int row;
    private int col;
    private Piece piece;
    private ChessColor color;

    public Square(int row, int col, ChessColor color){
        this.row = row;
        this.col = col;
        this.color = color;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if(piece != null) {
            piece.setSquare(this);
        }
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }

    public void removePiece(){
        this.piece = null;
    }

    public Piece getPiece(){
        return this.piece;
    }
}
