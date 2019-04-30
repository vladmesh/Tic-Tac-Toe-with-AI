package tictactoe;

import java.util.List;

class HardAI extends Player {
    private char enemyToken;
    HardAI(char token) {
        super(token);
        enemyToken = token == 'X' ? 'O' : 'X';
    }

    @Override
    void move(Field field) {
        System.out.println("Making move level \"hard\"");
        List<int[]> emptyCells = field.emptyCells();
        int max = -20;
        int[] pair = {-1, -1};
        for (int[] coordinate : emptyCells) {
            Field nextField = new Field(field.cells);
            nextField.cells[coordinate[0]][coordinate[1]] = token;
            int points = minmax(nextField, enemyToken);
           // System.out.println(points);
            if (points > max) {
                max = points;
                pair = coordinate;
            }
        }
       // System.out.println(Arrays.toString(pair));
        field.cells[pair[0]][pair[1]] = token;
        field.checkState();

    }

    private int minmax(Field field, char currentToken) {
        field.checkState();
        if (field.state == State.Draw) {
           // System.out.println(0);
            return 0;
        }
        if (field.state == State.XWins && token == 'X' || field.state == State.OWins && token == 'O'){
          //  System.out.println(1);
            return 1;

        }
        if (field.state == State.XWins && token == 'O' || field.state == State.OWins && token == 'X') {
            //System.out.println(-1);
            return -1;
        }
        List<int[]> emptyCells = field.emptyCells();
        int max = currentToken == token ? -20 : 20;
        for (int[] coordinate : emptyCells) {
            Field nextField = new Field(field.cells);
            nextField.cells[coordinate[0]][coordinate[1]] = currentToken;
            int points = minmax(nextField, currentToken == 'X'?'O':'X');
            if (token == currentToken && points > max || token != currentToken && points < max) {
                max = points;
               // System.out.println(max);
            }
        }
        return max;
    }
}
