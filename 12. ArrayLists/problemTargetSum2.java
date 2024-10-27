import java.util.ArrayList;
import java.util.Arrays;

public class problemTargetSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11,15,6,8,9,10));
        int target = 16;
        System.out.println(solution(list, target));
    }

    public static ArrayList<Integer> solution(ArrayList<Integer> list, int target) { // Optimized (Two-Pointer) - O(n)
        int n = list.size();
        int breakPoint = 0;
        for(int i = 0; i < list.size()-1; i++) {
            if (list.get(i) > list.get(i+1)) {
                breakPoint = i;
            }
        }
        int lp = (breakPoint + 1) % n;
        int rp = (breakPoint) % n;
        while (lp != rp) {
            if ((list.get(lp) + list.get(rp)) == target) {
                return new ArrayList<>(Arrays.asList(list.get(lp), list.get(rp)));
            } else if ((list.get(lp) + list.get(rp)) < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        return new ArrayList<>();
    }
}
