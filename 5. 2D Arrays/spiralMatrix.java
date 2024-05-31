public class spiralMatrix {
    public static void main(String args[]) {
        int[][] matrix = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
        spiral(matrix);
    }

    public static void spiral(int[][] matrix) {
        int sr = 0;
        int er = matrix.length-1;
        int sc = 0;
        int ec = matrix[0].length-1;
        while (er >= sr && ec >= sr) {
            for(int i = sc; i <= ec; i++) { //top
                System.out.print(matrix[sr][i] + " ");
            }
            for(int i = sr+1; i <= er; i++) { //right
                System.out.print(matrix[i][ec] + " ");
            }
            for(int i = ec - 1; i >= sc; i--) {
                System.out.print(matrix[er][i]+ " ");
            }
            for(int i = er-1; i >= sc+1; i--) {
                System.out.print(matrix[i][sc] + " ");
            }
            sr++;
            er--;
            sc++;
            ec--;
        }
    }
}
