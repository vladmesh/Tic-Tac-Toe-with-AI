package tictactoe;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class EasyAI extends Player {
    private Random random;
    EasyAI(char token) {
        super(token);
        random = new Random();
    }
    @Override
    void move(Field field) {
        System.out.println("Making move level \"easy\"");
        List<int[]> pairs = field.emptyCells();
        int[] pair = pairs.get(random.nextInt(pairs.size()));
        field.cells[pair[0]][pair[1]] = token;
        field.checkState();
    }
}
