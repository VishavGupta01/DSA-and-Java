import java.util.LinkedList;
import java.util.List;

public class mergeSortLL {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(6);

        System.out.println("Original List: " + list);
        List<Integer> sortedList = mergeSort(list);
        System.out.println("Sorted List: " + sortedList);
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        if(list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Integer> left = mergeSort(list.subList(0, mid));
        List<Integer> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new LinkedList<>();
        int i = 0, j = 0;

        while(i < left.size() && j < right.size()) {
            if(left.get(i) <= right.get(j)) {
                merged.add(left.get(i++));
            } else merged.add(right.get(j++));
        }

        merged.addAll(left.subList(i, left.size()));
        merged.addAll(right.subList(j, right.size()));

        return merged;
    }
}
