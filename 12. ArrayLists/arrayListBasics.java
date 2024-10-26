import java.util.ArrayList;
import java.util.Collections;

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

        // 1.5. Adding Elements at Index  // TC: O(n)
        list.add(2,12);
        System.out.println(list);

        // 2. Get Element  // TC: O(1)
        System.out.println(list.get(1));
        System.out.println(list.get(0));

        // 3. Delete Element  // TC: O(n) {Linear because all the elements after the removed element have to be shifted.}
        list.remove(2);
        System.out.println(list);

        // 4. Set Element at index  // TC: O(n)
        list.set(0, 10);
        System.out.println(list);

        // 5. Contains element?  // TC: O(n)
        System.out.println(list.contains(5));
        System.out.println(list.contains(4));

        // Size of an ArrayList
        System.out.println(list.size());

        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //Collections Sort [Ascending Order]
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        // Collections Sort (Reverse) [Descending Order]
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        //2D ArrayLists
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        mainList.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        mainList.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        mainList.add(list3);
        System.out.println(mainList);
        System.out.println(mainList.get(0).get(0));
    }
}
