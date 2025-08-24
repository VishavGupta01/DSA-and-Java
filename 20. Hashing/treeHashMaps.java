import java.util.TreeMap;

public class treeHashMaps {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>(); // Sorted by Keys , Implemented by Red-Black Trees

        // put, get, remove are in O(log n)
        map.put("India", 100);
        map.put("China", 150);
        map.put("Nepal", 20);

        System.out.println(map);

        System.out.println("India : " + map.get("India"));

        System.out.println("Removed : " + map.remove("China"));

        System.out.println("Size: " + map.size());

        for(String s : map.keySet()) {
            System.out.println("{ " + s + " -> " + map.get(s) + " } ");
        }
    }
}
