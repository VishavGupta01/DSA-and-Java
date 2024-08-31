import java.util.*;

public class loops {
    public static void main(String[] args) {
        multiplicationTable();
    }

    public static void multiplicationTable() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + i*number);
        }
    }

    public static void factorial() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int factorial = 1;
        if (number == 0) {
            System.out.println("Factorial of the number is 1.");
        } else {
            for(int i = number ; i > 0  ; i--) {
                factorial *= i;
            }
            System.out.println("Factorial of the number is " + factorial + ".");
        }
    }

    public static void sumOfEvenAndOddUserInputs() {
        Scanner sc = new Scanner(System.in);
        int sumOfEven = 0;
        int sumOfOdd = 0;
        for(int i = 0; i < 10; i++) {
            int number = sc.nextInt();
            if (number%2==0) {
                sumOfEven += number;
            } else {
                sumOfOdd += number;
            }
        }
        System.out.println("Sum of all Even Numbers input: " + sumOfEven);
        System.out.println("Sum of all Odd Numbers input: " + sumOfOdd);
    }

    public static void isPrime() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        boolean isPrime = true;

        if (number == 2) {
            System.out.println("Your Number is a Prime Number!");
        } else {
            for (int i = 2; i < Math.sqrt(number) ; i++) { //Math.sqrt(number) cuz max unique factors of a number can be from 2 to √number.
                int a = number % i;
                if (a == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == false) {
                System.out.println("Your Number is not a Prime Number!");
            } else {
                System.out.println("Your Number is a Prime Number!");
            }
        }
    }

    public static void printUserInputsExceptMultiplesOf10() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num = sc.nextInt();
            if (num % 10 == 0) {
                continue;
            }
            System.out.println(num);
        }
    }

    public static void userInputTillMultipleEntered() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        while (true) {
            int number = sc.nextInt();
            if (number % 10 == 0) {
                System.out.println(number + " is multiple of 10!");
                break;
            }
        }
    }

    public static void doWhileSyntax() {
        int counter = 0;
        do {
            System.out.println(counter + ". Hello World!");
            counter++;
        } while (counter < 10);
    }

    public static void reverseOfANumber() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        // for(int i = 0; i < 4; i++){
        //     System.out.print(a%10);
        //     a = a/10;
        // }

        while (a > 0) {
            System.out.print(a%10);
            a /= 10;
        }
    }

    public static void reverseOfAGivenNumber() {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();
        int reverse = 0 ;
        int lastDigit;
        while (num > 0) {
            lastDigit = num % 10;
            reverse = (reverse * 10) + lastDigit;
            num /= 10;
        }
        System.out.println(reverse);
    }

    public static void squarePattern() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of side of square: ");
        int side = sc.nextInt();
        for(int i = 0 ; i < side ; i++){
            for(int j=0 ; j < side ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void forSyntax() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ". Hello World!");
        }
    }

    public static void whileSyntax() {
        int counter = 0;
        while (counter<1000000) {
            System.out.println(counter + ". Hello World!");
            counter++;
        }
    }

    public static void infiteWhile() {
        while (true) {
            System.out.println("hi");
        }
    }

    public static void print1to10() {
        int counter = 1;
        while (counter <= 10) {
            System.out.println(counter);
            counter++;
        }
    }

    public static void print1ton() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        int counter = 1;
        while (counter <= n) {
            System.out.println(counter);
            counter++;
        }
    }

    public static void sumOfFirstNNaturalNums() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int counter = 1;
        int sum = 0;
        while (counter <= n) {
            sum += counter;
            counter++;
        }
        System.out.println(sum);
    }
}
