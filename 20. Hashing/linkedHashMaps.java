import java.util.LinkedHashMap;

public class linkedHashMaps {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(); // Doubly Linked List is used inside

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
