// Place N queens on a N*N chessboard such that no 2 queens can attack each other.
// Solutions:
// -> All Solutions
// -> Yes/No
// -> Count the number of Solutions
public class problemNQueens { // TC: O(n!) => T(n) = 1 Queen placing (n) * T(n-1) + isSafe()
    public static void main(String[] args) {
        int n = 5;
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[1].length; j++) {
                board[i][j] = '.';
            }
        }
        nQueens(board, 0);
        System.out.println("Number of solutions: " + count);
    }

    public static int count = 0;

    public static void printBoard(char[][] board) {
        System.out.println("--- Chess Board ---");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[1].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // We only Check upper rows Cuz we haven't placed any Queen at bottom Rows.
        //Vertical Upper Col Check
        for(int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //Left Upper Diagonal Check
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //Right Upper Diagonal Check
        for(int i = row - 1, j = col + 1; i >= 0 && j < board[i].length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueens(char[][] board, int row) {
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        for(int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i) == true) {
                board[row][i] = 'Q';
                nQueens(board, row+1);
                board[row][i] = '.';
            }
        }
    }
}