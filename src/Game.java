package src;

public class Game {
    private Board board;
    private Piece selectedPiece;

    public Game() {
        this.board = new Board();
    }

    public void selectPiece(Square square) {
        this.selectedPiece = square.getPiece();
    }
    public Board getBoard() {
        return this.board;
    }

    public void movePiece(Square targetSquare) {
        if(selectedPiece != null) {
            Square startSquare = selectedPiece.getSquare();
            startSquare.removePiece();  // Remove reference from the old square
            selectedPiece.setSquare(targetSquare); // Update the piece's square reference
            targetSquare.setPiece(selectedPiece);  // Update reference in the new square
            selectedPiece = null; // Clear the selected piece after moving
        }
    }
}
