public class Board {

    private char[][] board = new char[5][5];

    public char[][] getBoard() {
        return board;
    }

    public void printBoard() {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(j % 2 == 0 && i % 2 == 0) System.out.print(' ');
                if(j % 2 != 0 && i % 2 != 0) System.out.print('+');
                if(j % 2 != 0 && i % 2 == 0) System.out.print('|');
                if(j % 2 == 0 && i % 2 != 0) System.out.print('-');
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean takeSpace(Player player, int pos) {
        switch(pos) {
            case 1:
                if(board[0][0] == 0) {
                    board[0][0] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 2:
                if(board[0][2] == 0) {
                    board[0][2] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 3:
                if(board[0][4] == 0) {
                    board[0][4] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 4:
                if(board[2][0] == 0) {
                    board[2][0] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 5:
                if(board[2][2] == 0) {
                    board[2][2] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 6:
                if(board[2][4] == 0) {
                    board[2][4] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 7:
                if(board[4][0] == 0) {
                    board[4][0] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 8:
                if(board[4][2] == 0) {
                    board[4][2] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
            case 9:
                if(board[4][4] == 0) {
                    board[4][4] = player.getPiece();
                    return true;
                }
                else {
                    System.out.println("Space is taken");
                    return false;
                }
        }
        return false;
    }

    public boolean hasWon(Player player, char[][] board) {
        //Vertical
        if(
            board[0][0] == player.getPiece() &&
            board[2][0] == player.getPiece() &&
            board[4][0] == player.getPiece()
        ) return true;
        if(
            board[0][2] == player.getPiece() &&
            board[2][2] == player.getPiece() &&
            board[4][2] == player.getPiece()
        ) return true;
        if(
            board[0][4] == player.getPiece() &&
            board[2][4] == player.getPiece() &&
            board[4][4] == player.getPiece()
        ) return true;

        //Horizontal
        if(
            board[0][0] == player.getPiece() &&
            board[0][2] == player.getPiece() &&
            board[0][4] == player.getPiece()
        ) return true;
        if(
            board[2][0] == player.getPiece() &&
            board[2][2] == player.getPiece() &&
            board[2][4] == player.getPiece()
        ) return true;
        if(
            board[4][0] == player.getPiece() &&
            board[4][2] == player.getPiece() &&
            board[4][4] == player.getPiece()
        ) return true;

        //Diagonal
        if(
            board[0][0] == player.getPiece() &&
            board[2][2] == player.getPiece() &&
            board[4][4] == player.getPiece()
        ) return true;
        if(
            board[0][4] == player.getPiece() &&
            board[2][2] == player.getPiece() &&
            board[4][0] == player.getPiece()
        ) return true;

        return false;
    }

    public boolean isDraw(char[][] board) {
        int piecesPlaced = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 'X' || board[i][j] == 'O') piecesPlaced++;
            }
        }
        return (piecesPlaced == 9);
    }
}
