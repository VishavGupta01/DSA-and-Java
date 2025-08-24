import java.util.HashMap;

public class maxSubArrayLenWithSumZero {
    public static int solution(int[] arr) {
        int sum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            
            if(map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // int[] arr = {15, -2, 2, -8, 1, 7, 10};
        int[] arr = {1, -1, 3, 4};

        System.out.println(solution(arr));
    }
}
