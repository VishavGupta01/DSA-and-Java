import java.util.ArrayList;

public class minHeap {
    static class MinHeap { // Min Heap
        ArrayList<Integer> heap = new ArrayList<>();

        public void add(int data) { // O(log n)
            heap.add(data);

            int i = heap.size() - 1;
            int pIdx = (i - 1) / 2;

            while(i > 0 && heap.get(pIdx) > heap.get(i)) {
                int temp = heap.get(pIdx);
                heap.set(pIdx, heap.get(i));
                heap.set(i, temp);

                i = pIdx;
                pIdx = (i - 1) / 2;
            }
        }

        public int peek() {
            if(heap.size() == 0) {
                throw new IllegalStateException("Empty Heap!");
            }
            return heap.get(0);
        }

        public int delete() {
            int n = heap.size();

            // Base Case
            if(n == 0) {
                throw new IllegalStateException("Heap is Empty");
            }

            int data = heap.get(0);

            // Putting Bottom most and Right most val on top and removing the last element
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            // Heapifing the Parent (Compare parent with children and swap with smaller element)
            int parent = 0;
            n = heap.size();

            while(true) {
                int child1 = parent * 2 + 1;
                int child2 = parent * 2 + 2;
                int min = parent;

                if(child1 < n && heap.get(min) > heap.get(child1)) {
                    min = child1;
                }

                if(child2 < n && heap.get(min) > heap.get(child2)) {
                    min = child2;
                }

                if(min == parent) break;

                int temp = heap.get(parent);
                heap.set(parent, heap.get(min));
                heap.set(min, temp);

                parent = min;
            }

            return data;
        }

        public boolean isEmpty() {
            return heap.size() == 0;
        }

        public ArrayList<Integer> heapSort() { // Ascending Order
            ArrayList<Integer> res = new ArrayList<>();
            while(!isEmpty()) {
                res.add(delete());
            }
            return res;
        }

        public ArrayList<Integer> heapSortReverse() {
            int n = heap.size();
            ArrayList<Integer> res = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                res.add(0);
            }

            for(int i = n - 1; i >= 0; i--) {
                res.set(i, delete());
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(8);
        minHeap.add(1);

        System.out.println(minHeap.heap);
        System.out.println(minHeap.peek());

        System.out.println(minHeap.heapSort());
    }
}