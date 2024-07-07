public class recursionProblems {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(arraySorted(array, 0));
    }

    //Q1. Print numbers from 1 to n
    public static void incOrder(int i, int n) {
        if (i == n) {
            System.out.println(i);
            return;
        }
        System.out.println(i);
        incOrder(i+1 , 5);
    }

    //Q2. Factorial of n [ n * (n-1) * (n-2) * (n-3) ... 2 * 1 ]
    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 1;
        }
        int fact = n * factorial(n-1);
        return fact;
    }

    //Q3. Print Sum of first n natural numbers.
    public static int sumOfnNaturalNo(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + sumOfnNaturalNo(n-1);
        return sum;
    }

    //Q4. Print nth Fibonacci Series. [ 0, 1, 1, 2, 3, 5, 8, 13 ...]
    public static int fibonacci(int n) { //Space Complexity => O(n) , Time Complexity => O(2^n)
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int fib = fibonacci(n-1) + fibonacci(n-2);
        return fib;
    }

    //Q5. Check if an array is sorted.
    public static boolean arraySorted(int[] array, int i) {
        if (i == array.length-1) {
            return true;
        }
        if (array[i] > array[i+1]) {
            return false;
        }
        return arraySorted(array, i+1);
    }
}
