import java.util.PriorityQueue;

public class weakestSoldier {
    static class Row implements Comparable<Row>{
        int count;
        int idx;

        public Row(int[] r, int idx) {
            this.count = 0;
            for(int i : r) {
                if(i == 1) this.count++;
            }
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2) {
            if(this.count == r2.count) {
                return this.idx - r2.idx;
            }
            return this.count - r2.count;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}
        };
        int k = 3;

        PriorityQueue<Row> pq = new PriorityQueue<>();
        int i = 0;
        for(int[] r : mat) {
            pq.add(new Row(r, i++));
        }

        for(int j = 0; j < k; j++) {
            System.out.println(pq.poll().idx);
        }
    }
}
