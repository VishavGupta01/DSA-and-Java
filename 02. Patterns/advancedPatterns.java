import java.util.*;

public class advancedPatterns {
    public static void main(String args[]) {
        diamondPattern();
    }

    //Hollow Rectangle (Matrix of [4,5] {Rows,Columns})
    // *****
    // *   *
    // *   *
    // *****
    //Rows = 4 & Columns = 5
    public static void hollowRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the Number of Columns: ");
        int columns = sc.nextInt();
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                //cuz stars only occurred at boundaries which were when row was (1 or 4) or columns (1 or 5)
                if (i == 1 || i == rows || j == 1 || j == columns) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //Inverted & Rotated Half Pyramid
    //   *
    //  **
    // ***
    //****
    //Base = 4
    public static void InvertedRotatedHalfPyramid() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Base of the Pyramid: ");
        int base = sc.nextInt();
        for(int i = 1; i <= base; i++) {
            //here in each mth row from total n rows , there are n-m spaces and m number of stars
            //total columns in a row are (no of spaces) + (no of stars)
            //total rows = Spaces(total rows - row no) + Stars(row no)
            //so in row1, spaces(4-1=3) + stars(1)
            for(int j = 1; j <= base - i; j++) {
                System.out.print(" "); //Printing Spaces
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("*"); //Printing Stars
            }
            System.out.println();
        }
    }

    //Inverted Half Pyramid
    //12345
    //1234
    //123
    //12
    //1
    public static void InvertedHalfPyramid() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Depth of Pyramid: ");
        int depth = sc.nextInt();
        for(int i = 1; i <= depth; i++) {
            for(int j = 1; j <= depth-i+1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //Floyd's Triangle
    //1
    //2 3
    //4 5 6
    //7 8 9 10
    public static void floydTriangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Depth of the Triangle: ");
        int depth = sc.nextInt();
        int counter = 1;
        for(int i = 1; i <= depth; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    //0-1 Triangle
    //1
    //0 1
    //1 0 1
    //0 1 0 1
    public static void zeroOneTriangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height of the Triangle: ");
        int height =  sc.nextInt();
        for(int i = 1; i <= height; i++) {
            for(int j = 1; j <= i; j++) {
                if ((i+j)%2 == 0) {
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    //ButterFly Pattern
    // *             *
    // * *         * *
    // * * *     * * *
    // * * * * * * * *
    // * * * * * * * *
    // * * *     * * *
    // * *         * *
    // *             *
    public static void ButterFlyPattern() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width of the ButterFly: ");
        int n = sc.nextInt();
        //Upper Image of ButterFly
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for(int k = 1; k <= (n-i)*2 ; k++) {
                System.out.print("  ");
            }
            for(int l = 1; l <= i; l++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //Lower Water Image of Butterfly
        // for(int i = 1; i <= n; i++) {
        //     for(int j = n; j >= i; j--) {
        //         System.out.print("* ");
        //     }
        //     for(int k = 1; k <= (i-1)*2; k++) {
        //         System.out.print("  ");
        //     }
        //     for(int l = n; l >= i; l--) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        //      OR
        //we can simply inverse the outer loop
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for(int k = 1; k <= (n-i)*2 ; k++) {
                System.out.print("  ");
            }
            for(int l = 1; l <= i; l++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Solid Rhombus
    //         * * * * *
    //       * * * * *
    //     * * * * *
    //   * * * * *
    // * * * * *
    public static void solidRhombus() {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the side of Rhombus: ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            for(int k = 1; k <= n; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //Hollow Rhombus
    //         * * * * *
    //       *       *
    //     *       *
    //   *       *
    // * * * * *
    public static void hollowRhombus() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the side of Rhombus: ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            for(int k = 1; k <= n; k++) {
                if (i == 1 || i == n || k == 1 || k == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    //Diamond Pattern
    //       *
    //     * * *
    //   * * * * *
    // * * * * * * *
    // * * * * * * *
    //   * * * * *
    //     * * *
    //       *
    public static void diamondPattern() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the side of Diamond: ");
        int n = sc.nextInt();
        //Upper Half
        for(int i = 1; i <= n; i++) {
            //Spaces
            for(int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            //Stars
            for(int k = 1; k <= (i*2)-1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        //Lower Half / Inverse
        for(int i = n; i >= 1; i--) {
            //Spaces
            for(int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }
            //Stars
            for(int k = 1; k <= (i*2)-1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
