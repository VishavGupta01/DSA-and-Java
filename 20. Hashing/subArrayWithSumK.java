import java.util.HashMap;

public class subArrayWithSumK {
    public static int solution(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxCount = 0;
        map.put(0, 1);

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum == k) {
                maxCount++;
            }

            if(map.containsKey(sum - k)) {
                maxCount += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        System.out.println(solution(arr, k));
    }
}
