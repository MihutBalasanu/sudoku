
public class MySudoku {


    private static int n;
    private static int[][] mySudoku = new int[n][n];


    public static void showSudoku(int[][] mySudoku){
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

    public static void makeMove(SudokuMove sudokuMove) {
        mySudoku[sudokuMove.line][sudokuMove.column] = sudokuMove.moveValue;
        showSudoku(mySudoku);
    }

    public static int[][]smallSudoku(SudokuMove sudokuMove){
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


     public static boolean isValidMove(SudokuMove sudokuMove){ 
        
        int test;
// Testarea liniei
        for (int j = 0; j < 9; j++) {
            test = mySudoku[sudokuMove.line][j];
            for (int k = 0; k < 9; k++) {
                if(k != j && mySudoku[sudokuMove.line][k] == test){
                    return false;
                }
            }
        }
// Testarea coloanei
        for (int i = 0; i < 9; i++) {
            test = mySudoku[i][sudokuMove.column];
            for (int k = 0; k < 9; k++) {
                if(k != i && mySudoku[k][sudokuMove.column] == test){
                    return false;
                }
            }
        }
// Testarea regiunii        
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

