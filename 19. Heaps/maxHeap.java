import java.util.ArrayList;

public class maxHeap {
    static class MaxHeap {
        ArrayList<Integer> maxHeap = new ArrayList<>();

        public void add(int data) {
            maxHeap.add(data);

            int i = maxHeap.size() - 1;
            int pIdx = (i - 1) / 2;

            while(i > 0 && maxHeap.get(pIdx) < maxHeap.get(i)) {
                int temp = maxHeap.get(pIdx);
                maxHeap.set(pIdx, maxHeap.get(i));
                maxHeap.set(i, temp);

                i = pIdx;
                pIdx = (i - 1) / 2;
            }
        }

        public int peek() {
            if(maxHeap.size() == 0) {
                throw new IllegalStateException("Empty Heap!");
            }
            return maxHeap.get(0);
        }

        public int delete() {
            if(maxHeap.size() == 0) {
                throw new IllegalStateException("Empty Heap!");
            }

            int data = maxHeap.get(0);
            maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
            maxHeap.remove(maxHeap.size() - 1);

            int parent = 0;
            int n = maxHeap.size();

            while(true) {
                int child1 = parent * 2 + 1;
                int child2 = parent * 2 + 2;
                int max = parent;

                if(child1 < n && maxHeap.get(max) < maxHeap.get(child1)) {
                    max = child1;
                }

                if(child2 < n && maxHeap.get(max) < maxHeap.get(child2)) {
                    max = child2;
                }

                if(parent == max) break;

                int temp = maxHeap.get(parent);
                maxHeap.set(parent, maxHeap.get(max));
                maxHeap.set(max, temp);

                parent = max;
            }
            return data;
        }

        public boolean isEmpty() {
            return maxHeap.size() == 0;
        }

        public ArrayList<Integer> heapSort() { // Ascending Order
            int n = maxHeap.size();
            ArrayList<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                res.add(0);
            }

            for(int i = n - 1; i >= 0; i--) {
                res.set(i, delete());
            }
            return res;
        }

        public ArrayList<Integer> heapSortReverse() { // Descending Order
            ArrayList<Integer> res = new ArrayList<>();
            while(!isEmpty()) {
                res.add(delete());
            }
            return res;
        }
    }
}
