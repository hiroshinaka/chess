package src;

public class Board {
    private Square[][] squares = new Square[8][8];

    public Board(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                ChessColor squareColor = (i +j)% 2 ==0 ? ChessColor.WHITE : ChessColor.BLACK;
                squares[i][j] = new Square(i,j, squareColor);
            }
        }
    }
    public void initializeStandardSetup() {
        //Initialize Pawns
        for (int i = 0; i < 8; i++) {
            squares[1][i].setPiece(new Pawn(ChessColor.BLACK));
            squares[6][i].setPiece(new Pawn(ChessColor.WHITE));
        }

        //Initialize Rooks
        squares[0][0].setPiece(new Rook(ChessColor.BLACK));
        squares[0][7].setPiece(new Rook(ChessColor.BLACK));
        squares[7][0].setPiece(new Rook(ChessColor.WHITE));
        squares[7][7].setPiece(new Rook(ChessColor.WHITE));

        //Initialize Knights
        squares[0][1].setPiece(new Knight(ChessColor.BLACK));
        squares[0][6].setPiece(new Knight(ChessColor.BLACK));
        squares[7][1].setPiece(new Knight(ChessColor.WHITE));
        squares[7][6].setPiece(new Knight(ChessColor.WHITE));

        //Initialize Bishop
        squares[0][2].setPiece(new Bishop(ChessColor.BLACK));
        squares[0][5].setPiece(new Bishop(ChessColor.BLACK));
        squares[7][2].setPiece(new Bishop(ChessColor.WHITE));
        squares[7][5].setPiece(new Bishop(ChessColor.WHITE));

        //Initialize King
        squares[0][3].setPiece(new King(ChessColor.BLACK));
        squares[7][3].setPiece(new King(ChessColor.WHITE));

        //Initialize Queen
        squares[0][4].setPiece(new Queen(ChessColor.BLACK));
        squares[7][4].setPiece(new Queen(ChessColor.WHITE));
    }


    public Square getSquare(int row, int col){
        return squares[row][col];
    }
}
