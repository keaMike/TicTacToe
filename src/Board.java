class Board {

    private char[][] board = new char[5][5];
    private int piecesPlaced = 0;

    public Board() {
        // On restart set pieces placed to zero
        piecesPlaced = 0;
    }

    char[][] getBoard() {
        return board;
    }

    public int getPiecesPlaced() {
        return piecesPlaced;
    }

    void printBoard() {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(j % 2 == 0 && i % 2 == 0 && board[i][j] == 0) System.out.print(' ');
                if(j % 2 != 0 && i % 2 != 0) System.out.print('+');
                if(j % 2 != 0 && i % 2 == 0) System.out.print('|');
                if(j % 2 == 0 && i % 2 != 0) System.out.print('-');
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    boolean takeSpace(char playerPiece, int pos) {
        switch(pos) {
            case 1:
                return placePiece(playerPiece ,0,0);
            case 2:
                return placePiece(playerPiece, 0, 2);
            case 3:
                return placePiece(playerPiece, 0, 4);
            case 4:
                return placePiece(playerPiece, 2, 0);
            case 5:
                return placePiece(playerPiece, 2, 2);
            case 6:
                return placePiece(playerPiece, 2, 4);
            case 7:
                return placePiece(playerPiece, 4, 0);
            case 8:
                return placePiece(playerPiece, 4, 2);
            case 9:
                return placePiece(playerPiece, 4, 4);
        }
        return false;
    }

    private boolean placePiece(char playerPiece, int row, int col) {
        if(board[row][col] == 0) {
            board[row][col] = playerPiece;
            piecesPlaced++;
            return true;
        }
        else {
            System.out.println("Space is taken.. Try again");
            return false;
        }
    }

    boolean hasWon(char playerPiece, char[][] board) {

        //Vertical
        for(int i = 0; i < 6; i += 2) {
            if(board[0][i] == playerPiece && board[2][i] == playerPiece && board[4][i] == playerPiece) return true;
        }
        //Horizontal
        for(int i = 0; i < 6; i += 2) {
            if (board[i][0] == playerPiece && board[i][2] == playerPiece && board[i][4] == playerPiece) return true;
        }
        //Diagonal
        if(board[0][0] == playerPiece && board[2][2] == playerPiece && board[4][4] == playerPiece) return true;
        if(board[0][4] == playerPiece && board[2][2] == playerPiece && board[4][0] == playerPiece) return true;
        return false;
    }
}
