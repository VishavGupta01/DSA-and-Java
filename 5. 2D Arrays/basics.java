import java.util.Scanner;

public class basics {
    public static void main(String args[]) {
        basic();
    }

    public static void basic(){
        int[][] matrix = new int[5][5];
        Scanner sc = new Scanner(System.in);
        int n = 5, m = 5;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        //Output
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean linearSearch(int[][] matrix, int key) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    return true;
                }
            }
        }
        return false;
    }
}

