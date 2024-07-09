public class recursionAssignment {
    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,5,3};
        search(array, 3, 0);
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
}