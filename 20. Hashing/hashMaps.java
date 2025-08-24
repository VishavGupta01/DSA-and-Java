import java.util.HashMap;

public class hashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding a pair -> O(1)
        map.put("India", 100);
        map.put("China", 150);
        map.put("Pakistan", -1);

        // System.out.println(map); 

        // // Get -> O(1)
        // System.out.println(map.get("India"));
        // System.out.println(map.get("Nepal"));

        // // Contains -> O(1)
        // System.out.println(map.containsKey("India"));
        // System.out.println(map.containsKey("Nepal"));

        // // Remove -> O(1)
        // int chinaPop = map.remove("China");
        // System.out.println(chinaPop);
        // System.out.println(map);

        // // Size -> O(1)
        // System.out.println(map.size());

        // // isEmpty -> O(1)
        // System.out.println(map.isEmpty());

        // // Clear -> O(n)
        // map.clear();
        // System.out.println(map.isEmpty());

        // Iteration
        for(String s : map.keySet()) {
            System.out.println("{ " + s + " -> " + map.get(s) + " } ");
        }
    }
}
