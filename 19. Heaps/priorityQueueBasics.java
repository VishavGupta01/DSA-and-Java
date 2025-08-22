import java.util.Comparator;
import java.util.PriorityQueue;

public class heapsBasics {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // By default minHeap
        // for maxHeap ```new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(1); // O(log n)
        // pq.add(3);
        // pq.add(2);
        // System.out.println(pq.peek()); // O(1)

        // while(!pq.isEmpty()) {
        //     System.out.println(pq.remove()); // O(log n)
        // }

        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("Vishav", 10));
        pq.add(new Student("xyz", 100));
        pq.add(new Student("abc", 1000));

        while(!pq.isEmpty()) {
            Student curr = pq.remove();
            System.out.println("Name : " + curr.name + " Rank : " + curr.rank);
        }
    }
}
