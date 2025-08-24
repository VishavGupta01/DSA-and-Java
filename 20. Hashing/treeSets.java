import java.util.TreeSet;

public class treeSets {
    public static void main(String[] args) { // Does not allow Nulls
        TreeSet<String> set = new TreeSet<>(); // Implemented with TreeMaps

        set.add("b");
        set.add("b");
        set.add("c");
        set.add("a");

        System.out.println(set);
    }
}
