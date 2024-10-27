import java.util.ArrayList;
import java.util.Arrays;

public class problemContainerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>(Arrays.asList(1,8,6,2,5,4,8,3,7));
        System.out.println(solution1(height));
    }

    public static int solution1(ArrayList<Integer> list) { // Brute Force - O(n^2)
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++) {
                int volume = (j-i)*(Integer.min(list.get(i), list.get(j)));
                result = Integer.max(result, volume);
            }
        }
        return result;
    }
}
