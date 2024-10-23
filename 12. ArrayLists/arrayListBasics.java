import java.util.ArrayList;

public class arrayListBasics {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Operations on ArrayLists
        // 1. Add Element  // TC: O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        // 2. Get Element  // TC: O(1)
        System.out.println(list.get(1));
        System.out.println(list.get(0));
    }
}
