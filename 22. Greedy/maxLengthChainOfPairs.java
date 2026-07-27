import java.util.*;

public class maxLengthChainOfPairs {
    // You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
    // A pair (c, d) can come after pair (a, b) if "b < c".
    // Find the longest chain which can be formed from a given set of pairs.

    public static void solution(int[][] pairs) {
        int chainLength = 0;

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int latestMaxNum = Integer.MIN_VALUE;
        ArrayList<int[]> results = new ArrayList<>();

        for(int i = 0; i < pairs.length; i++) {
            int a = pairs[i][0], b = pairs[i][1];

            if(a > latestMaxNum) {
                chainLength++;
                latestMaxNum = b;
                results.add(pairs[i]);
            }
        }

        System.out.println("Max Chain Length: " + chainLength);
        for(int[] r : results) {
            System.out.print(Arrays.toString(r) + " -> ");
        }
        System.out.print("End");
    }

    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        solution(pairs);
    }
}
