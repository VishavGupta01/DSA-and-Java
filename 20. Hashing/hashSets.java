import java.util.HashSet;
import java.util.Iterator;

public class hashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);
        System.out.println(set.size());

        // set.clear();

        // Iteration 1 using Iterators
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Iteration 2 using for loops
        for(int i : set) {
            System.out.println(i);
        }

    }
}
