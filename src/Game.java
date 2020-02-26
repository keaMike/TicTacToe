import java.util.Scanner;

class Game {

    private Board board = new Board();
    private Player playerOne = new Player("X", 'X');
    private Player playerTwo = new Player("O", 'O');
    private int turn = 0;

    private Scanner sc = new Scanner(System.in);

    private boolean gameEnded;

    void start() {

        System.out.println(
                "Welcome to Tic Tac Toe \n"
        );
        board.printBoard();

        Player currentPlayer;

        while(!gameEnded) {

            currentPlayer = nextPlayer(turn);

            System.out.println(
                    currentPlayer.getName() + " it's your turn\n" +
                    "Place your piece with a number between 1-9"
            );
            // Take space method with the player piece and a pos 1-9 as parameters.
            // If space available, take space and turn to next player.
            int pos = sc.nextInt(); sc.nextLine();
            if(board.takeSpace(currentPlayer.getPiece(), pos)) {
                turn++;
            }
            board.printBoard();

            // Checks all possible winning combinations on current board and return bool.
            if(board.hasWon(currentPlayer.getPiece(), board.getBoard())) {
                System.out.println(currentPlayer.getName() + " YOU HAVE WON!\nWant to play again? y/n");
                gameEnded = true;
                // If no one has won, check if nine pieces have been placed, if so it is a draw.
            } else if(board.getPiecesPlaced() == 9) {
                System.out.println("GAME ENDED DRAW!\nWant to play again? y/n");
                gameEnded = true;
            }
        }

        // Runs game again on a new board.
        if(sc.nextLine().equalsIgnoreCase("y")) {
           restart();
        }
    }

    // Method to switch between players.
    private Player nextPlayer(int turn) {
        if(turn % 2 == 0) return playerOne;
        else return playerTwo;
    }

    private void restart() {
        gameEnded = false;
        board = new Board();
        turn = 0;
        start();
    }
}
