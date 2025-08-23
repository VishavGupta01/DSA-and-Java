import java.util.PriorityQueue;

public class nearestKPoints {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int disSq;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.disSq = x*x + y*y;
        }

        @Override
        public int compareTo(Point s2) {
            return this.disSq - s2.disSq;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[][] point = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        for(int[] p : point) {
            pq.add(new Point(p[0], p[1]));
        }

        for(int i = 0; i < k; i++) {
            System.out.println("[" + pq.peek().x + ", " + pq.peek().y + "]");
            pq.remove();
        }
    }
}
