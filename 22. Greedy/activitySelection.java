public class activitySelection {

    public static int solution(int[] start, int[] end) {
        int count = 0;

        // Finding non-overlapping activities.
        int latestEndTime = 0;
        for(int i = 0; i < end.length; i++) {
            if(start[i] >= latestEndTime) {
                count++;
                latestEndTime = end[i];
            }
        }

        return count;
    }

    public static void main(String args[]) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9}; // Already Sorted in increasing order of end time.

        System.out.println(solution(start, end));
    }
}
