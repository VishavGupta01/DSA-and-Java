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
    }
}
