import java.util.Collections;
import java.util.PriorityQueue;

public class slidingWindowMaximum {
    static class Window implements Comparable<Window> {
        int idx;
        int val;

        public Window(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Window w2) {
            return w2.val - this.val;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;

        PriorityQueue<Window> pq = new PriorityQueue<>();

        int i = 0;
        while(i < arr.length) {
            pq.add(new Window(i, arr[i]));
            if(i >= k - 1) {
                while(pq.peek().idx < i - k + 1) pq.poll();
                System.out.print(pq.peek().val + " ");
            }
            i++;
        }
    }
}
