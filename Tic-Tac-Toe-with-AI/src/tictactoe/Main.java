package tictactoe;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        final char[] tokens = {'X', 'O'};
        final Player[] players = new Player[2];
        while (true) {
            System.out.println("Input command\n" +
                    "1. New game\n" +
                    "2. Exit");
            command = scanner.next();
            if ("2".equals(command)) {
                break;
            }
            try {
                if ("1".equals(command)) {
                    for (int i = 0; i < 2; i++) {
                        System.out.println("Choose a " + tokens[i] + " Player:\n" +
                                "1. Human\n" +
                                "2. Easy AI\n" +
                                "3. Medium AI\n" +
                                "4. Hard AI\n");
                        command = scanner.next();

                        switch (command) {
                            case "1":
                                players[i] = new User(tokens[i], scanner);
                                break;
                            case "2":
                                players[i] = new EasyAI(tokens[i]);
                                break;
                            case "3":
                                players[i] = new MediumAI(tokens[i]);
                                break;
                            case "4":
                                players[i] = new HardAI(tokens[i]);
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    }
                    Game game = new Game(new Field(3), players[0], players[1]);
                    game.start();
                }
                else throw new IllegalArgumentException();
            }
            catch(IllegalArgumentException e){
                System.out.println("Bad parameters!");
            }
        }

    }
}
