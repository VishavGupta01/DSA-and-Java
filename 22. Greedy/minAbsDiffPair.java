import java.util.*;

public class minAbsDiffPair {
    // Given two Arrays A and B of "equal length n". Pair each element of array A to an element in array B, such that   "sum S of absolute differences of all the pairs is minimum".

    public static void solution(int[] A, int[] B) {
        long sum = 0;

        int n = A.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0; i < n; i++) {
            sum += Math.abs(A[i] - B[i]);
        }

        System.out.println("Ans:  " + sum);
    }

    public static void main(String[] args) {
        int[] A = {4, 1, 8, 7};
        int[] B = {2, 3, 6, 5};

        solution(A, B);
    }
}
