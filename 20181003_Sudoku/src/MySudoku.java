
public class MySudoku {


    private int n;
    private int[][] game = new int[n][n];

    public MySudoku(int n) {
        this.n = n;
    }

    public MySudoku(int[][] game) {
        this.game = game;
    }
// Afisarea unei instante mySudoku

    public void showGame(int[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game.length; j++) {
                if (game[i][j] == 0) {
                    System.out.print("\t");
                } else {
                    System.out.print(game[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
    // Crearea unei noi instante mySudoku dupa o mutare

    public void makeMove(SudokuMove sudokuMove) {
        game[sudokuMove.line][sudokuMove.column] = sudokuMove.moveValue;
        showGame(game);
    }

    // Generarea regiunii de 3 X 3 corespunzatoare unei mutari ( unei instante sudokuMove )

    public int[][] extractSudokuRegionOfMove(SudokuMove sudokuMove) {
        int[][] smallSudoku = new int[3][3];
        int r = sudokuMove.line - sudokuMove.line % 3;
        int c = sudokuMove.column - sudokuMove.column % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                smallSudoku[i - r][j - c] = game[i][j];
            }
        }
        return smallSudoku;
    }

    // Testarea de linie

    public boolean isValidLine(SudokuMove sudokuMove) {

        int test;
        for (int j = 0; j < 9; j++) {
            test = game[sudokuMove.line][j];
            for (int k = 0; k < 9; k++) {
                if (k != j && game[sudokuMove.line][k] == test) {
                    return false;
                }
            }
        }
        return true;
    }

    // Testul de coloana

    public boolean isValidColumn(SudokuMove sudokuMove) {

        int test;
        for (int i = 0; i < 9; i++) {
            test = game[i][sudokuMove.column];
            for (int k = 0; k < 9; k++) {
                if (k != i && game[k][sudokuMove.column] == test) {
                    return false;
                }
            }
        }
        return true;
    }

    // Testul de regiune 3 X 3

    public boolean isValidRegion(SudokuMove sudokuMove) {

        int test;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                test = extractSudokuRegionOfMove(sudokuMove)[i][j];
                for (int k = 0; k < 3; k++) {
                    if (k != i && extractSudokuRegionOfMove(sudokuMove)[k][j] == test) {
                        return false;
                    } else {
                        if (k != j && extractSudokuRegionOfMove(sudokuMove)[i][k] == test) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}




