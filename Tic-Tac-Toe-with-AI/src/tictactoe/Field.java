package tictactoe;

import java.util.*;


class Field  {
    char[][] cells;
    int size;
    State state;
    Map<Character, Integer> tokens;
    int[][] inColumn;
    int[][] inRow;
    int[] inMainDiagonal;
    int[] inSideDiagonal;
    Field(int size){
        cells = new char[size][size];
        for (char[] chars : cells) {
            Arrays.fill(chars, ' ');
        }

        this.size = size;
        state = State.NotFinished;

        tokens = new HashMap<>();
        tokens.put('X', 1);
        tokens.put('O', 0);

        inColumn = new int[2][size];
        inRow = new int[2][size];
        inMainDiagonal = new int[2];
        inSideDiagonal = new int[2];
    }

    Field(char[][] cells){
        this(cells.length);
        for (int i = 0; i < cells.length ; i++) {
            System.arraycopy(cells[i], 0, this.cells[i], 0, cells.length);

        }

    }

    void checkState() {
        boolean[] wins = {false, false}; //who win
        int[] count = new int[2];   //number of both tokens
        boolean hasEmpty = false;
        inColumn = new int[2][size];
        inRow = new int[2][size];
        inMainDiagonal = new int[2];
        inSideDiagonal = new int[2];


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == ' ') {
                    hasEmpty = true;
                    continue;
                }
                int token = tokens.get(cells[i][j]);
                count[token]++;
                inColumn[token][j]++;
                inRow[token][i]++;
                if (i == j) inMainDiagonal[token]++;
                if (i + j == size - 1) inSideDiagonal[token]++;
                if (inColumn[token][j] == size || inRow[token][i] == size || inMainDiagonal[token] == size || inSideDiagonal[token] == size) {
                    wins[token] = true;
                }
            }
        }
        if ((wins[1] && wins[0]) || Math.abs(count[0] - count[1]) > 1) {
            state = State.Incorrect;
        } else if (wins[1]) state = State.XWins;
        else if (wins[0]) state = State.OWins;
        else if (hasEmpty) state = State.NotFinished;
        else state = State.Draw;
    }

    void printField() {
        System.out.println("---------");
        for (char[] chars : cells) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    List<int[]> emptyCells(){
        List<int[]> coordinates = new LinkedList<>();
        int[] pair;
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                if(cells[i][j] == ' '){
                    pair = new int[2];
                    pair[0] = i;
                    pair[1] = j;
                    coordinates.add(pair);
                }
            }
        }
        return coordinates;
    }
}
