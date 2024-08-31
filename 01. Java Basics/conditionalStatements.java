import java.util.*;

public class conditionalStatements {
    public static void main(String args[]){
        leapYear();
    }

    public static void randomTests() {
        // else {
        //     System.out.println("hi");
        // }
    }

    public static void leapYear() {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        boolean x = (year%4)==0;
        boolean y = (year%100) != 0;
        boolean z = ((year%100==0) && (year%400==0));
        if (x && ( y || z)) {
            System.out.println(year + " is a Leap Year!");
        } else {
            System.out.println(year + " is not a Leap Year!");
        }
    }

    public static void dayOfWeek() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        switch (num) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }

    public static void feverOrNot() {
        double temp = 103.5;
        System.out.println((temp > 100)?"Fever":"No Fever");
    }

    public static void positveOrNegative() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println((number < 0)?"negative":"positive");
    }

    public static void ternaryOpLargerOfTwo() {
        int a = 50;
        int b = 6;
        int larger = ( a > b ) ? a : b;
        System.out.println(larger + " is the Largest Number!");
    }

    public static void ternaryOpOddOrEven() {
        int a = 50;
        System.out.println((a%2==0)?"even":"odd");
    }

    public static void ternaryOpPassOrFail() {
        Scanner sc = new Scanner(System.in);
        int marks = sc.nextInt();
        System.out.println((marks<33)?"fail":"pass");
    }

    public static void incomeTax() {
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        double tax;

        if ( salary < 500000 ) {
            tax = 0;
        } else if ( salary <= 500000 && salary > 1000000 ) {
            tax = salary * 0.2;
        } else {
            tax = salary * 0.3;
        }

        double inHandSalary = salary - tax;
        System.out.println("Taxes to be paid: " + tax);
        System.out.println("In Hand Salary after deducting taxes: " + inHandSalary);
    }

    public static void largestOfTwo() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if ( a > b ) {
            System.out.println(a + " is largest number.");
        } else {
            System.out.println(b + " is the largest number.");
        }
    }

    public static void largestOfThree() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // if ( a > b) {
        //     if ( a > c) {
        //         System.out.println(a + " is the Largest Number!");
        //     }
        //     else {
        //         System.out.println(c + " is the Largest Number!");
        //     }
        // } else {
        //     if ( b > c ) {
        //         System.out.println(b + " is the Largest Number!");
        //     }
        //     else {
        //         System.out.println(c + " is the Largest Number!");
        //     }
        // }

        // OR

        if ( ( a > b ) && (a > c) ) {
            System.out.println(a + " is the Largest Number!");
        } else if ( b > c) {
            System.out.println(b + " is the Largest Number!");
        } else {
            System.out.println(c + " is the Largest Number!");
        }
    }

    public static void oddEven() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num%2 == 0) {
            System.out.println("Number is even!");
        } else {
            System.out.println("Number is Odd!");;
        }
    }

    public static void age() {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age >= 18) {
            System.out.println("You are an Adult!");
        } else if (age >= 13 && age < 18) {
            System.out.println("You are a Teenager!");
        } else {
            System.out.println("You are a Child!");
        }
    }

    public static void comparison() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if ( a == b ) {
            System.out.println("a = b");
        } else if (a > b) {
            System.out.println("a > b");
        } else  {
            System.out.println("a < b");
        }
    }

    public static void switchCase() {
        Scanner sc = new Scanner(System.in);
        int button = sc.nextInt();
        switch (button) {
            case 1:
                System.out.println("Hello!");
                break;
            case 2:
                System.err.println("Namaste!");
                break;
            case 3:
                System.out.println("Bonjour!");
                break;
            default:
                System.out.println("Invalid Button Input!!");;
                break;
        }
    }

    public static void calculator() {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        char op = sc.next().charAt(0);
        int result = 0;
        boolean flag = false;

        switch (op) {
            case '+':
                result = a1 + b1;
                flag = true;
                break;

            case '-':
                result = a1 - b1;
                flag = true;
                break;

            case '*':
                result = a1 * b1;
                flag = true;
                break;

            case '/':
                result = a1 / b1;
                flag = true;
                break;

            case '%':
                result = a1 % b1;
                flag = true;
                break;

            default:
                break;
        }

        if (flag == false) {
            System.out.println("Invalid Operator entered!");
        } else {
            System.out.println("Result : " + result);
        }
    }

    public static void monthName() {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        switch (num1) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }
}
