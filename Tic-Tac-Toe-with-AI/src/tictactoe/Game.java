package tictactoe;

class Game {
    private Field field;
    private Player playerX;
    private Player playerO;

    Game(Field field, Player playerX, Player playerO) {
        this.playerO = playerO;
        this.playerX = playerX;
        this.field = field;
    }


    void start() {
        field.printField();
        while (field.state == State.NotFinished) {
            playerX.move(field);
            field.printField();
            if (field.state != State.NotFinished) break;
            playerO.move(field);
            field.printField();
        }
        switch (field.state) {
            case Draw:
                System.out.println("Draw");
                break;
            case XWins:
                System.out.println("X wins");
                break;
            case OWins:
                System.out.println("O wins");
                break;
            default:
                System.out.println("ERROR!");
        }

    }
}
