import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class assignment {
    public static void main(String[] args) {
        // int nums[] = {1,2,3,4,5,1};
        // System.out.println(distinctArray(nums));


        // int prices[] = {7,1,5,3,6,4};
        // stocks(prices);

        // int height[] = {4,2,0,6,3,2,5};
        // rainWater(height);

        int nums[] = {-1,0,1,2,-1,-4};
        triplets(nums);
    }

    //Question 1. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public static boolean distinctArray(int nums[]) {
        boolean flag = false;
        //Brute Force
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return flag = true;
                }
            }
        }
        return flag;
    }

    //Question 2. There is an integer array nums sorted in ascending order (with distinct values).Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k],nums[k+1], ... ,nums[n-1], nums[0], nums[1], ... , nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2]. Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.You must write an algorithm with O(log n) runtime complexity.
    public static void rotatedArray() {
        int nums[] = {4,5,6,7,0,1,2};
        int key = 0;

    }

    //Question 3. You  are  given  an  array prices where prices[i] is  the  price  of  a  given  stock  on  the ith day.Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static void stocks(int prices[]) {
        int lowest = Integer.MAX_VALUE; //Buy Price
        int maxProfit = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length-1; i++) {
            lowest = Math.min(prices[i], lowest);
            int profit = prices[i+1] - lowest;
            maxProfit = Math.max(maxProfit, profit);
        }
        System.out.println(maxProfit);
    }

    //Question 4. Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
    public static void rainWater(int height[]) {
        int len = height.length;
        int leftBound[] = new int[len];
        int rightBound[] = new int[len];
        int width = 1;
        int trappedWater = 0;

        leftBound[0] = height[0];
        for(int i = 1; i < len; i++) {
            leftBound[i] = Math.max(height[i], leftBound[i-1]);
        }

        rightBound[len-1] = height[len-1];
        for(int i = len-2; i >= 0; i--) {
            rightBound[i] = Math.max(height[i], rightBound[i+1]);
        }

        for(int i = 0; i < len; i++) {
            trappedWater += (((Math.min(leftBound[i], rightBound[i])) - height[i]) * width );
        }
        System.out.println("Max Trapped Rain Water = " + trappedWater);
    }

    //Question 5. Given an integer array nums, return all the triplets [nums[i], nums[j],  nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.Notice that the solution set must not contain duplicate triplets.
    public static boolean isUnique(int array[], ArrayList<int[]> result) {
        for(int i = 0; i < result.size(); i++) {
            if (Arrays.equals(result.get(i), array)) {
                return false;
            }
        }
        return true;
    }
    public static void triplets(int nums[]) {
        int n = nums.length;
        int sum = 0;
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    int array[] = {nums[i], nums[j], nums[k]};
                    Arrays.sort(array);
                    if (sum == 0 && isUnique(array, result)) {
                        result.add(array);
                    }
                }
            }
        }
        for(int i = 0; i < result.size(); i++) {
            int[] triplet = result.get(i);
            System.out.println(Arrays.toString(triplet));
        }
    }
}
