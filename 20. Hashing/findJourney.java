import java.util.HashMap;
import java.util.HashSet;

public class findJourney {

    public static String getStart(HashMap<String, String> tix) {
        HashSet<String> destinations = new HashSet<>();

        for(String s : tix.values()) {
            destinations.add(s);
        }

        for(String s : tix.keySet()) {
            if(!destinations.contains(s)) return s;
        }
        return null;
    }

    public static void solution(HashMap<String, String> tix) {
        String start = getStart(tix);

        System.out.print(start + " -> ");
        String curr = start;
        while(tix.containsKey(curr)) {
            System.out.print(tix.get(curr) + " -> ");
            curr = tix.get(curr);
        }
        System.out.print("End");
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        solution(tickets);
    }
}