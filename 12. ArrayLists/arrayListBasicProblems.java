import java.util.ArrayList;

public class arrayListBasicProblems {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Q1. Reverse of an ArrayList
        for(int i=list.size(); i > 0; i--) {
            System.out.print(list.get(i-1) + " ");
        }

        // Q2. Maximum in an ArrayList
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            int val = list.get(i);
            if (val > max) {
                max = val;
            }
        }
        System.out.println("Maximum Value in the ArrayList is: " + max);

        // Q3. Swap values at two Indexes
        int index1 = 1, index2 = 2;
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
        System.out.println(list);
    }
}
