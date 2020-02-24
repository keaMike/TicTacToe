import java.util.Scanner;

public class Game {

    private Board board = new Board();
    private Player playerOne = new Player("X", 'X');
    private Player playerTwo = new Player("O", 'O');
    private int turn = 0;

    private Scanner sc = new Scanner(System.in);

    private boolean gameEnded;

    public void start() {

        System.out.println(
                "Welcome to Tic Tac Toe \n"
        );
        board.printBoard();

        Player currentPlayer = null;

        while(!gameEnded) {

            currentPlayer = nextPlayer(turn);

            System.out.println(
                    currentPlayer.getName() + " it's your turn\n" +
                    "Place your piece with a number between 1-9"
            );
            int pos = sc.nextInt(); sc.nextLine();
            if(board.takeSpace(currentPlayer, pos)) turn++;
            board.printBoard();

            if(board.hasWon(currentPlayer, board.getBoard())) {
                System.out.println(currentPlayer.getName() + " YOU HAVE WON!\nWant to play again? y/n");
                gameEnded = true;
            }
            if(board.isDraw(board.getBoard())) {
                System.out.println("GAME ENDED DRAW!\nWant to play again? y/n");
                gameEnded = true;
            }
        }

        if(sc.nextLine().equalsIgnoreCase("y")) {
            gameEnded = false;
            board = new Board();
            start();
        }
    }

    public Player nextPlayer(int turn) {
        if(turn % 2 == 0) return playerOne;
        else return playerTwo;
    }
}
