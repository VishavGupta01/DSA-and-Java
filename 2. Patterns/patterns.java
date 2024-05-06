import java.util.*;

public class patterns {
    public static void main(String[] args) {
        characterPyramid();
    }

    public static void starPyramid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the height of the Pyramid: ");
        int number = sc.nextInt();
        char star = '*';
        for(int i = 0; i<number; i++){
            for(int j = 0; j<=i; j++){
                System.out.print(star);
            }
            System.out.println();
        }
    }

    public static void invertedPyramid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the depth of the Pyramid: ");
        int number = sc.nextInt();
        char star = '*';
        for(int i = 0; i < number; i++) {
            for(int j = number - i; j > 0; j-- ) { //number of stars in a line are getting reduced by 1 per line so number - i
                System.out.print(star);
            }
            System.out.println();
        }
    }

    public static void halfPyramid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the height of the Pyramid: ");
        int number = sc.nextInt();
        char star = '*';
        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void characterPyramid() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the height of the Pyramid: ");
        int number = sc.nextInt();
        char ch = 'A';
        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
