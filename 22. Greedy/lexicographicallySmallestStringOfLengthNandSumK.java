import java.util.Arrays;

public class lexicographicallySmallestStringOfLengthNandSumK {
    // We have two integers N and K.
    // The task is to print the lexicographically smallest string of length N consisting of lower-case English alphabets such that the sum of the characters of the string equals to K where 'a' = 1, 'b' = 2, ... and 'z' = 26.

    public static char[] DICT = {
        'a', 'b', 'c', 'd',
        'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l',
        'm', 'n', 'o', 'p',
        'q', 'r', 's', 't',
        'u', 'v', 'w', 'x',
             'y', 'z'
    };

    public static void solution(int n, int k) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        int sum = n;

        int i = n - 1;
        while(sum < k) {
            int diff = Math.min((k - sum), 25);
            res[i] = (char) ((int) res[i] + diff);
            i--;
            sum += diff;
        }

        System.out.println(new String(res));
    }

    public static void main(String[] args) {
        int n = 3, k = 25;
        solution(n, k);
    }
}
