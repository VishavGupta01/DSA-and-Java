public class splitTheGivenArrayIntoKSubArrays {
    // We have an Array[] of N elements and a number K (1 <= K <= N).
    // Split the given array into K subarrays (they must cover all the elements).
    // The maximum subarray sum achievable out of the K subarrays formed must be the minimum possible.
    // Find that possible subarray sum.

    public static int solution(int[] arr, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i : arr) {
            sum += i;
            max = Math.max(max, i);
        }

        int low = max, high = sum;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int partitions = countPartitions(mid, arr);

            if(partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countPartitions(int maxSum, int[] arr) {
        int partitions = 1;
        long sum = 0;

        for(int num : arr) {
            if(sum + num > maxSum) {
                partitions++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return partitions;
    }

    public static void main(String[] args) {
        int[] array = {25, 46, 28, 49, 24};
        int k = 4;
        System.out.println(solution(array, k));
    }
}
