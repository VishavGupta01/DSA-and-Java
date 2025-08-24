import java.util.*;

public class hashMapsImplementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int N; // N
        private int n;
        private LinkedList<Node> buckets[];
        private double k; // threshold for ReHashing

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.n = 0;
            this.buckets = new LinkedList[4];
            this.k = 2.0;
            for(int i = 0; i < 4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public int bucketIdx(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        public int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for(int i = 0; i < ll.size(); i++) {
                Node n = ll.get(i);
                if(n.key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        public void reHash() {
            LinkedList<Node>[] oldBuckets = buckets;

            N = N * 2;
            buckets = new LinkedList[N];

            for(int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }

            n = 0;
            for(int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for(Node n : ll) {
                    put(n.key, n.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = bucketIdx(key);
            int di = searchInLL(key, bi);

            if(di != - 1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = (double) n/N;
            if(lambda > k) {
                reHash();
            }
        }

        public boolean containsKey(K key) {
            int di = searchInLL(key, bucketIdx(key));
            if(di == -1) {
                return false;
            }
            return true;
        }

        public V remove(K key) {
            int bi = bucketIdx(key);
            int di = searchInLL(key, bi);
            if(di == -1) {
                return null;
            }
            else {
                LinkedList<Node> ll = buckets[bi];
                n--;
                return ll.remove(di).value;
            }
        }

        public V get(K key) {
            int bi = bucketIdx(key);
            int di = searchInLL(key, bi);
            if(di == -1) {
                return null;
            }
            else {
                LinkedList<Node> ll = buckets[bi];
                return ll.get(di).value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> list = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node n : ll) {
                    list.add(n.key);
                }
            }
            return list;
        }

        public int size() {
            return n;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("China", 150);
        map.put("Nepal", 10);
        map.put("Pakistan", 20);

        System.out.println(map.get("India"));
        System.out.println(map.containsKey("USA"));
        System.out.println(map.remove("Nepal"));
        System.out.println(map.size());
        System.out.println(map.keySet());
    }
}
