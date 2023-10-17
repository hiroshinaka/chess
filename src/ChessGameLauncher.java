package src;

public class ChessGameLauncher {

    public static void main(String[] args) {
        Game game = new Game();
        game.getBoard().initializeStandardSetup();
        GUI gui = new GUI(game.getBoard());
        gui.displayBoard(game.getBoard());

    }

}
