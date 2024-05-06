import java.util.*;

public class functionsAndMethods {
    public static void main(String[] args) {
        //Call by Value;
        // int a = 5;
        // callByValue(a);
        // System.out.println(a);

        sumOfDigits(123);

    }

    public static void printHW() {
        System.out.println("Hello World!");
    }

    public static int sumOfTwo(int a, int b) {
        return a + b;
    }

    public static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public static void callByValue(int a) {
        a = 10;
        System.out.println(a);
    }

    public static int productOfTwo(int a, int b) {
        return a*b;
    }

    public static int factorial(int n) {
        int fact = 1;
        for ( int i = 1; i<=n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static float binomialCoefficient(int n, int r) { //binomialCoefficient = nCr = (n!) / (r! * (n-r)!)
        float a = factorial(n) / (factorial(r) * factorial(n-r));
        return a;
    }

    //Method Overloading by Number of Parameters
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    //Method Overloading by DataTypes of Parameters
    public static int sumDT(int a, int b) {
        return a + b;
    }

    public static float sumDT(float a, float b) { //Function DataType doesn't affect Overloading
        return a + b;
    }

    public static boolean isPrime(int n) {
        //corner case (n=2)
        if (n == 2) {
            return true;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeInRange() {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        for(int i = num1; i<=num2; i++) {
            boolean flag = isPrime(i);
            if (flag == true) {
                System.out.print(i + " ");
            }
        }
    }

    public static int binaryToDecimal(int n) {
        int decimal = 0;
        for(int pow = 0; n > 0 ; pow++) {
            decimal = decimal + ((n%10) * (int)Math.pow(2, pow));
            n = n/10;
        }
        return decimal;
    }

    public static int decimalToBinary(int n) {
        int binary = 0;
        int pow = 0;
        while (n > 0) {
            int remainder = n % 2;
            binary = binary + (remainder * (int)Math.pow(10, pow));
            pow++;
            n = n / 2;
        }
        return binary;
    }

    //Practice Questions

    public static int avgOfThree(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static boolean isEven(int n) {
        if (n % 2 ==0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome(int n) {
        int num = n;
        int revNum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            revNum = (revNum * 10) + lastDigit;
            n /= 10;
        }
        if (revNum == num) {
            return true;
        } else {
            return false;
        }
    }

    public static void sumOfDigits(int n) {
        int sum = 0;
        int num = n;
        while (n != 0) {
            sum = sum + (n%10);
            n /= 10;
        }
        System.out.println("Sum of digits of " + num + ": " + sum);
    }

}
