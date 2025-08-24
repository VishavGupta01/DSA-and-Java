import java.util.HashSet;

public class hashSetQuestions {
    public static int distinctElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }
        return set.size();
    }

    public static void unionIntersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : arr1) set.add(i);
        for(int i : arr2) set.add(i);
        System.out.println("Union : " + set.size());
        set.clear();

        for(int i : arr1) set.add(i);
        int count = 0;
        for(int i : arr2) {
            if(set.contains(i)) {
                count++;
                set.remove(i);
            }
        }
        System.out.println("Intersection : " + count);
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        System.out.println(distinctElements(arr));

        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        unionIntersection(arr1, arr2);
    }
}
