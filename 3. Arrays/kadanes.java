public class kadanes {
    public static void main(String args[]) {
        int array[] = {-1,-2,-3,-4,5}; // negative Case
        //int array[] = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(kadanesalgo(array));
    }

    public static int kadanesalgo(int array[]) {// Time Complexity = O(n) & Space Complexity = O(1)
        boolean flag = false;
        for(int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                flag = false;
            }
        }
        if (flag == false) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            return max;
        }

        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            cs = cs + array[i];
            if (cs <= 0) {
                cs = 0;
            }
            ms = Math.max(ms, cs);
        }
        return ms;
    }
}
