public class problemSudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku ={
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
            printSudoku(sudoku);
            solver(sudoku, 0, 0);
            printSudoku(sudoku);
    }

    public static void printSudoku(int[][]sudoku) {
        System.out.println("--- Sudoku ---");
        for(int i = 0; i < sudoku.length; i++) {
            for(int j = 0; j < sudoku[i].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checker(int[][] sudoku, int row, int col, int element) {
        // Col
        for(int i = 0; i < 9; i++) {
            if (sudoku[row][i] == element) {
                return false;
            }
        }
        // Row
        for(int i = 0; i < 9; i++) {
            if (sudoku[i][col] == element) {
                return false;
            }
        }
        // Grid
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        for(int i = startRow; i < startRow+3; i++) {
            for(int j = startCol; j < startCol+3; j++) {
                if (sudoku[i][j] == element) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solver(int[][] sudoku, int row, int col) {
        // Base Case
        if (row == 9) {
            return true;
        }

        // Recursion
        if (col == 9) {
            return solver(sudoku, row+1, 0);
        }
        if (sudoku[row][col] != 0) {
            return solver(sudoku, row, col+1);
        }
        for(int element = 1; element < 10; element++) {
            if (checker(sudoku, row, col, element)) {
                sudoku[row][col] = element;
                if (solver(sudoku, row, col+1)) {
                    return true;
                } else {
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }
}
