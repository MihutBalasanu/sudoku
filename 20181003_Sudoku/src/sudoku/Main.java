package sudoku;

import java.util.Scanner;

import static sudoku.MySudoku.isValidMove;
import static sudoku.MySudoku.makeMove;

public class Main {

    public static void main(String[] args) {
        int n = 9;
        int[][] mySudoku = new int[9][9];
        int numberOfMoves = 0;
        while(numberOfMoves < 81){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Se face mutarea introducand: linia, coloana, valoarea; Ex: 2,3,8");
            String move = scanner.nextLine();
            String[] coords = move.split(",");
            Integer line = Integer.valueOf(coords[0]);
            Integer column = Integer.valueOf(coords[1]);
            Integer moveValue = Integer.valueOf(coords[2]);

            while(line >= 9 || column >= 9 || moveValue <=0 || moveValue > 9 ){
                System.out.println("Invalid move! ");
            }
            SudokuMove sudokuMove = new SudokuMove(line, column, moveValue);
            boolean test = isValidMove(sudokuMove);
            while(test = false){
                System.out.println("Invalid move! ");
            }
            makeMove(sudokuMove);
            numberOfMoves++;

        }
    }
}
