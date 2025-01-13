import java.util.LinkedList;

public class linkedListsJCF {
    public static void main(String[] args) {
        //Creation - Objects;
        LinkedList<Integer> list = new LinkedList<>();

        //Add Data;
        list.addFirst(0);
        list.add(1);
        list.add(2);

        //Printing
        System.out.println(list);

        //Removing
        list.removeLast();
        list.removeFirst();
        System.out.println(list);
    }
}
