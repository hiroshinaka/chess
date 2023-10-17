package src;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private ChessColor currentTurnColor = ChessColor.WHITE; // White starts the game
    private Game game;

    private Piece selectedPiece = null;
    private final int SQUARE_SIZE = 64;
    private JButton[][] boardButtons = new JButton[8][8];

    public GUI(Board board) {
        super("Chess Game");  // Set title of the window
        this.game = new Game();
        setupBoardGUI(game.getBoard());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Adjust the window size to fit its content
        setVisible(true); // Make the window visible
    }

    private void setupBoardGUI(Board board) {
        this.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                java.awt.Color awtColor = (i + j) % 2 == 0 ? java.awt.Color.WHITE : java.awt.Color.BLACK;

                if (awtColor == java.awt.Color.WHITE) {
                    button.setForeground(java.awt.Color.BLACK);
                } else {
                    button.setForeground(java.awt.Color.WHITE);
                }

                button.setBackground(awtColor);
                int finalI = i;
                int finalJ = j;
                button.addActionListener(e -> handleClick(finalI, finalJ));
                boardButtons[i][j] = button;
                this.add(button);
            }
        }
    }

    public void displayBoard(Board board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getSquare(i, j).getPiece();
                if (piece != null) {
                    boardButtons[i][j].setText(piece.getPieceName());
                } else {
                    boardButtons[i][j].setText(null);
                }
            }
        }
    }

    public void movePieceTo(int targetRow, int targetCol) {
        Square targetSquare = game.getBoard().getSquare(targetRow, targetCol);
        if(selectedPiece.isValidMove(selectedPiece.getSquare(), targetSquare)) {
            game.movePiece(targetSquare); // Use Game class to handle piece movement
            switchTurns();
            displayBoard(game.getBoard());
        }
    }


    public void switchTurns() {
        currentTurnColor = (currentTurnColor == ChessColor.WHITE) ? ChessColor.BLACK : ChessColor.WHITE;
    }

    public void handleClick(int row, int col) {
        Square clickedSquare = game.getBoard().getSquare(row, col);
        Piece clickedPiece = clickedSquare.getPiece();
        if(selectedPiece == null && clickedPiece != null && clickedPiece.getColor() == currentTurnColor) {
            game.selectPiece(clickedSquare); // select piece using the Game class
            selectedPiece = clickedPiece;
        } else if(selectedPiece != null) {
            if(game.getBoard().getSquare(row, col).getPiece() == null || game.getBoard().getSquare(row, col).getPiece().getColor() != currentTurnColor) {
                movePieceTo(row, col);
                selectedPiece = null; // reset selected piece after moving
            }
        }
    }

}
