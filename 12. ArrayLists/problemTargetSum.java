import java.util.ArrayList;
import java.util.Arrays;

public class problemTargetSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int target = 5;
        System.out.println(solution2(list, target));
    }

    public static ArrayList<Integer> solution1(ArrayList<Integer> list, int target) { // Brute Force - O(n^2)
        for(int i = 0; i < list.size()-1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return new ArrayList<>(Arrays.asList(list.get(i),list.get(j)));
                }
            }
        }
        return new ArrayList<>();
    }

    public static ArrayList<Integer> solution2(ArrayList<Integer> list, int target) { // Optimized (Two - Pointer) - O(n)
        int lp = 0, rp = list.size()-1;
        while(lp < rp) {
            if ((list.get(lp) + list.get(rp)) == target) {
                return new ArrayList<>(Arrays.asList(list.get(lp) , list.get(rp)));
            } else if ((list.get(lp) + list.get(rp)) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return new ArrayList<>();
    }
}
