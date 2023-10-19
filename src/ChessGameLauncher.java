package src;

public class ChessGameLauncher {

    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        game.getBoard().initializeStandardSetup();
        GUI gui = new GUI(game); // Pass the game instance to the GUI
        gui.displayBoard(game.getBoard());
    }
}

