package src;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private ChessColor currentTurnColor = ChessColor.WHITE; // White starts the game
    private Game game;

    private Piece selectedPiece = null;
    private final int SQUARE_SIZE = 64;
    private JButton lastHighlighted = null;
    private JButton[][] boardButtons = new JButton[8][8];
    private int lastHighlightedRow = -1;
    private int lastHighlightedCol = -1;


    public GUI(Game game) {
        super("Chess Game");
        this.game = game;
        setupBoardGUI(game.getBoard());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Adjust the window size to fit its content
        setSize(720,720);
        setVisible(true); // Make the window visible
    }


    private void setupBoardGUI(Board board) {
        this.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                java.awt.Color awtColor = (i + j) % 2 == 0 ? java.awt.Color.WHITE : java.awt.Color.BLACK;

                if (i < 4) {  // First 4 rows
                    button.setForeground(java.awt.Color.ORANGE);
                } else {  // Last 4 rows
                    button.setForeground(java.awt.Color.GREEN);
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
                    if (piece.getColor() == ChessColor.WHITE) {
                        boardButtons[i][j].setForeground(java.awt.Color.ORANGE);
                    } else {
                        boardButtons[i][j].setForeground(java.awt.Color.GREEN);
                    }
                } else {
                    boardButtons[i][j].setText(null);
                }
            }
        }
        if (lastHighlighted != null) {
            java.awt.Color originalColor = (lastHighlightedRow + lastHighlightedCol) % 2 == 0 ? java.awt.Color.WHITE : java.awt.Color.BLACK;
            lastHighlighted.setBackground(originalColor);
            lastHighlighted = null;
            lastHighlightedRow = -1;
            lastHighlightedCol = -1;
        }
    }




    public void movePieceTo(int targetRow, int targetCol) {
        Square targetSquare = game.getBoard().getSquare(targetRow, targetCol);
        if (selectedPiece.isValidMove(selectedPiece.getSquare(), targetSquare, game.getBoard())) {
            // Handle capturing
            Piece targetPiece = targetSquare.getPiece();
            if (targetPiece != null && targetPiece.getColor() != currentTurnColor) {
                // Capture the piece (if needed)
                targetSquare.setPiece(null);
            }

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

        // If another piece was previously selected, reset its color.
        if (lastHighlighted != null) {
            java.awt.Color originalColor = (lastHighlightedRow + lastHighlightedCol) % 2 == 0 ? java.awt.Color.WHITE : java.awt.Color.BLACK;
            lastHighlighted.setBackground(originalColor);
            lastHighlighted = null;
            lastHighlightedRow = -1;
            lastHighlightedCol = -1;
        }

        if (selectedPiece == null && clickedPiece != null && clickedPiece.getColor() == currentTurnColor) {
            game.selectPiece(clickedSquare); // select piece using the Game class
            selectedPiece = clickedPiece;

            lastHighlighted = boardButtons[row][col]; // Remember this button as the last highlighted one
            lastHighlightedRow = row; // Move this here
            lastHighlightedCol = col; // Move this here
            lastHighlighted.setBackground(java.awt.Color.YELLOW); // Highlight the selected piece with yellow color
        } else if (selectedPiece != null) {
            if (game.getBoard().getSquare(row, col).getPiece() == null || game.getBoard().getSquare(row, col).getPiece().getColor() != currentTurnColor) {
                movePieceTo(row, col);
                selectedPiece = null; // reset selected piece after moving
            }
        }
    }



}
