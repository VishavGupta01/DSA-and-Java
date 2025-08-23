import java.util.PriorityQueue;

public class minimumRopeCost {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ropes = {4, 3, 2, 6};
        int cost = 0;

        for(int rope : ropes) pq.add(rope);

        while(pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            cost += sum;
            pq.add(sum);
        }
        System.out.println("Minimum Cost: " + cost);
    }
}
