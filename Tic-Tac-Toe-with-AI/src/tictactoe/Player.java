package tictactoe;

abstract class Player {
    abstract void move(Field field);
    char token;
    Player(char token){
        this.token = token;
    }
}
