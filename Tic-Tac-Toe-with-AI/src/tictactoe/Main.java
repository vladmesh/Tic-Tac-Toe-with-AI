package tictactoe;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        final char[] tokens = {'X', 'O'};
        final Player[] players = new Player[2];
        while (true) {
            System.out.println("Input command");
            command = scanner.next();
            if ("exit".equals(command)) {
                break;
            }

            try {
                if (!"start".equals(command)) throw new IllegalArgumentException();
                for (int i = 0; i < 2; i++) {
                    String s = scanner.next();
                    switch (s) {
                        case "user":
                            players[i] = new User(tokens[i], scanner);
                            break;
                        case "easy":
                            players[i] = new EasyAI(tokens[i]);
                            break;
                        case "medium":
                            players[i] = new MediumAI(tokens[i]);
                            break;
                        case "hard":
                            players[i] = new HardAI(tokens[i]);
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
                Game game = new Game(new Field(3), players[0], players[1]);
                game.start();
            }
            catch (IllegalArgumentException e){
                System.out.println("Bad parameters!");
            }
        }

    }
}
