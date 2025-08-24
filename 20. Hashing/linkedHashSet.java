import java.util.LinkedHashSet;

public class linkedHashSet {
    public static void main(String[] args) { // Allows Nulls
        LinkedHashSet<String> set = new LinkedHashSet<>(); // Implemented with DLL

        set.add("Delhi");
        set.add("Patiala");
        set.add("Mumbai");
        set.add("Delhi");

        System.out.println(set);
    }
}
