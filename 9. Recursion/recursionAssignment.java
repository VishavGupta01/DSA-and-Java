public class recursionAssignment {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,5,3};
        String[] digits = {"zero" , "one" , "two" , "three" , "four" , "five" , "six" ,"seven" , "eight" , "nine"};
        //search(array, 3, 0);
        //conversion("", 2005, digits);
        stringLength("hello", 0);
    }

    //Q1. For a given integer array of size N. You have to find all the occurrences (indices) of a given element (Key) and print them. Use a recursive function to solve this problem.
    public static void search(int[] array, int key, int n) {
        if (n == array.length) {
            return;
        }
        if(array[n] == key) {
            System.out.println(n);
        }
        search(array, key, n+1);
    }

    //Q2. You are given a number (eg -  2019), convert it into a String of english like “two zero one nine”.  Use a recursive function to solve this problem. NOTE- The digits of the number will only be in the range 0-9 and the last digit of a number can’t be 0.
    public static void conversion(String result, int num, String[] map) {
        if (num == 0) {
            System.out.println(result);
            return;
        }
        int n = num % 10;
        result = map[n] + " " + result;
        conversion(result, num/10, map);
    }

    //Q3. Length of a String with Recursion.
    public static void stringLength(String string, int count) {
        if (string == "") {
            System.out.println(count);
            return;
        }
        stringLength(string.substring(1), count+1);
    }
}