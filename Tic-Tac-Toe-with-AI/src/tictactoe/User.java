package tictactoe;

import java.util.Scanner;

class User extends Player {
    private Scanner scanner;

    User(char token, Scanner scanner) {
        super(token);
        this.scanner = scanner;
    }

    @Override
    public void move(Field field) {
        boolean success = false;
        int x = 0, y = 0;
        while (!success) {
            System.out.println("Enter the coordinates: ");
            try {
                y = scanner.nextInt() - 1;
                x = scanner.nextInt() - 1;
                x = field.size - 1 - x;
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers");
                continue;
            }
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Coordinates should be from 1 to 3");
                continue;
            }
            if (field.cells[x][y] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            success = true;
        }

        field.cells[x][y] = token;
        field.checkState();
    }
}
