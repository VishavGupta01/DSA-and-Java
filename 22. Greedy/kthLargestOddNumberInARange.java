public class kthLargestOddNumberInARange {
    // We have two variables L and R, indicating a range of integers from L to R inclusive, and a number K.
    // The task is to find the Kth largest odd number.
    // If K > number of odd numbers in the range L to R then return 0.

    public static int solution(int L, int R, int K) {
        L = (L % 2 == 0) ? L + 1 : L;
        R = (R % 2 == 0) ? R - 1 : R;

        int oddNums = (R - L) / 2 + 1;

        if(oddNums < K) return 0;

        return R - (2 * K) + 2;
    }

    public static void main(String[] args) {
        int L = -3, R = 3, K = 1;
        System.out.println(solution(L, R, K));
    }
}
