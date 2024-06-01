public class assignment {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
            };
        //search(matrix, 10);

        int[][] array = { {4,7,8},{8,8,7} };
        //count(array, 7);

        int[][] nums = {{1,4,9},
                        {11,4,3},
                        {2,2,3} };
        //sumOfSecondRow(nums);

        transpose(nums);
    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void diagonalSum(int[][] matrix) {
        int sum = 0;
        //BruteForce Approach
        // for(int i = 0; i < matrix.length; i++) {
        //     for(int j = 0; j < matrix[0].length; j++) {
        //         if (i == j) {
        //             sum += matrix[i][j];
        //         } else if (i + j == matrix.length-1) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        //Optimized Approach O(n)
        for(int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
            int j = matrix.length-1-i;
            if (i != j) {
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }

    //From Top Right Cell
    public static boolean sortedMatrixSearch(int[][] matrix, int key) {
        int i = 0;
        int j = matrix[0].length-1;
        while (i < matrix.length-1 &&  j >= 0) {
            if (key == matrix[i][j]) {
                System.out.println("Element found at: Row - " + i + " , Column - " + j);
                return true;
            } else if (key < matrix[i][j]) {
                j--;
            } else if (key > matrix[i][j]) {
                i++;
            }
        }
        System.out.println("Element Not Found!");
        return false;
    }

    //From Bottom Left Cell
    public static boolean search(int[][] matrix, int key) {
        int row = matrix.length-1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == key) {
                System.out.println("Element found at: Row - " + row + " , Column - " + col);
                return true;
            } else if (matrix[row][col] > key) {
                row--;
            } else if (matrix[row][col] < key) {
                col++;
            }
        }
        System.out.println("Element Not Found!");
        return false;
    }

    //Question 1. Print the number of 7’s that are in the 2d array. Input - int[][] array = { {4,7,8},{8,8,7} };
    public static void count(int[][] matrix, int key) {
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == key) {
                    count++;
                }
            }
        }
        System.out.println("Total number of " + key + " in matrix are " + count);
    }

    //Question 2. Print out the sum of the numbers in the second row of the “nums” array. Input - int[][] nums = { {1,4,9},{11,4,3},{2,2,3} };
    public static void sumOfSecondRow(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix[1].length; i++) {
            sum += matrix[1][i];
        }
        System.out.println("Sum is " + sum);
    }

    //Question 3. Write a program to Find Transpose of a Matrix.
    public static void transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        printMatrix(matrix);
        System.out.println();
        printMatrix(transpose);
    }
}
