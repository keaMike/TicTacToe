class Player {

    private String name;
    private char piece;

    Player(String name, char piece) {
        this.name = name;
        this.piece = piece;
    }

    String getName() {
        return name;
    }

    char getPiece() {
        return piece;
    }
}
