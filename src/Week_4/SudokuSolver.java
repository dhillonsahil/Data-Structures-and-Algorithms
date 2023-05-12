package Week_4;
public class SudokuSolver {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {

        // check col
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit)
                return false;
        }

        // check row
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit)
                return false;
        }

        // check grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit)
                    return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0},
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };

        if(solveSudoku(sudoku, 0, 0)){
            System.out.println("Solution Exist ");
            printSudoku(sudoku);
        }else{
            System.out.println("no solution exists");
        }
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveSudoku(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }

        // recursion
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        // to place if only 0
        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (solveSudoku(sudoku, nextRow, nextCol)) { // solution exists
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

}
