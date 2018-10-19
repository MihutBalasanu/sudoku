
public class MySudoku {


    private int n;
    private MySudoku mySudoku = new MySudoku(n);

    public MySudoku(int n) {
        this.n = n;
        int[][] mySudoku = new int[n][n];
    }

    // Afisarea unei instante mySudoku

    public  void showSudoku(int[][] mySudoku){
        for (int i = 0; i < mySudoku.length; i++) {
            for (int j = 0; j < mySudoku.length; j++) {
                if (mySudoku[i][j] == 0){
                    System.out.print("\t");
                }else{
                    System.out.print(mySudoku[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
    // Crearea unei noi instante mySudoku dupa o mutare

    public void makeMove(SudokuMove sudokuMove) {
        mySudoku[sudokuMove.line][sudokuMove.column] = sudokuMove.moveValue;
        showSudoku(mySudoku);
    }

    // Generarea regiunii de 3 X 3 corespunzatoare unei mutari ( unei instante sudokuMove )

    public int[][]smallSudoku(SudokuMove sudokuMove){
        int[][]smallSudoku = new int[3][3];
        int r = sudokuMove.line - sudokuMove.line % 3;
        int c = sudokuMove.column - sudokuMove.column % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
              smallSudoku[i-r][j-c] = mySudoku[i][j];
            }
        }
        return smallSudoku;
    }

    // Testarea de linie

    public boolean isValidLine(SudokuMove sudokuMove) {

        int test;
        for (int j = 0; j < 9; j++) {
            test = mySudoku[sudokuMove.line][j];
            for (int k = 0; k < 9; k++) {
                if (k != j && mySudoku[sudokuMove.line][k] == test) {
                    return false;
                }
            }
        }
        return true;
    }

    // Testul de coloana

    public boolean isValidColumn(SudokuMove sudokuMove){

        int test;
        for (int i = 0; i < 9; i++) {
            test = mySudoku[i][sudokuMove.column];
                for (int k = 0; k < 9; k++) {
                    if (k != i && mySudoku[k][sudokuMove.column] == test) {
                        return false;
                    }
                }
            }
            return true;
        }

        // Testul de regiune 3 X 3

    public boolean isValidRegion(SudokuMove sudokuMove){

        int test;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                test = smallSudoku(sudokuMove)[i][j];
                for (int k = 0; k < 3; k++) {
                    if(k !=i && smallSudoku(sudokuMove)[k][j] == test){
                        return false;
                    }else{
                        if(k != j && smallSudoku(sudokuMove)[i][k] == test){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}




