package tictactoe;

import java.util.List;
import java.util.Random;

class MediumAI extends Player {
    private Random random;
    MediumAI(char token) {
        super(token);
        random = new Random();
    }


    @Override
    void move(Field field) {
        System.out.println("Making move level \"medium\"");
        //check if we can win in one move
        int[] coordinates = analise(field, token);

        //check if enemy can win in one move
        if(coordinates == null){
            char enemyToken = token == 'X'?'O':'X';
            coordinates = analise(field, enemyToken);
        }

        //else just use random
        if(coordinates == null){
            List<int[]> pairs = field.emptyCells();
            coordinates = pairs.get(random.nextInt(pairs.size()));
        }

        field.cells[coordinates[0]][coordinates[1]] = token;
        field.checkState();

    }
    @SuppressWarnings("Duplicates")
    private int[] analise(Field field, char token){
        int t = field.tokens.get(token);
        final int[] coordinates = new int[2];
        int[] columns = field.inColumn[t];
        for (int i = 0; i < field.size ; i++) {
            if(columns[i] == field.size-1){
                for (int j = 0; j < field.size ; j++) {
                    if(field.cells[j][i] == ' '){
                        coordinates[0] = j;
                        coordinates[1] = i;
                        return coordinates;
                    }
                }
            }
        }

        int[] rows = field.inRow[t];
        for (int i = 0; i < field.size ; i++) {
            if(rows[i] == field.size-1){
                for (int j = 0; j < field.size ; j++) {
                    if(field.cells[i][j] == ' '){
                        coordinates[0] = i;
                        coordinates[1] = j;
                        return coordinates;
                    }
                }
            }
        }

        if(field.inMainDiagonal[t] == field.size-1){
            for (int i = 0; i < field.size; i++) {
                if(field.cells[i][i] == ' '){
                    coordinates[0] = i;
                    coordinates[1] = i;
                    return coordinates;
                }
            }
        }

        if(field.inSideDiagonal[t] == field.size-1){
            for (int i = 0; i < field.size; i++) {
                if(field.cells[i][field.size - (i+1)] == ' '){
                    coordinates[0] = i;
                    coordinates[1] = field.size - (i+1);
                    return coordinates;
                }
            }
        }
        return null;
    }
}
