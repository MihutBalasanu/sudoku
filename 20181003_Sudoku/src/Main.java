import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MySudoku mySudoku = new MySudoku(9);
        int numberOfMoves = 0;
        while (numberOfMoves < 81) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Se face mutarea introducand: linia, coloana, valoarea; Ex: 2,3,8");
            String move = scanner.nextLine();
            String[] coords = move.split(",");
            Integer line = Integer.valueOf(coords[0]);
            Integer column = Integer.valueOf(coords[1]);
            Integer moveValue = Integer.valueOf(coords[2]);
            SudokuMove sudokuMove = new SudokuMove(line, column, moveValue);
            boolean test = MySudoku.isValidLine(sudokuMove) && MySudoku.isValidColumn(mySudoku) && MySudoku.isValidRegion(mySudoku);


            if (line >= 9 || column >= 9 || moveValue <= 0 || moveValue > 9 || !test) {
                System.out.println("Invalid move! ");

            } else {

                MySudoku.makeMove(sudokuMove);
                MySudoku.showSudoku(mySudoku);

                numberOfMoves++;

            }
        }
    }
}
