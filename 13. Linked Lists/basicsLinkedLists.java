public class basicsLinkedLists {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        Node temp = head;
        int i = 0;
        while(i < index-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked List Underflow!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked List Underflow!");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public void printLL(basicsLinkedLists list) { // O(n)
        Node temp = head;
        if (temp == null) {
            System.out.println("Linked List Underflow!");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int iterativeSearch(basicsLinkedLists list, int key) {
        Node temp = head;
        int i = 0;
        if (head == null) {
            System.out.println("List Underflow!");
            return -1;
        }
        while(temp != null) {
            if (temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public int recursiveSearch(basicsLinkedLists list, Node head1, int key) {
        if(head1 == null) {
            return -1;
        }
        if (head1.data == key) {
            return 0;
        }
        int idx = recursiveSearch(list, head1.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx+1;
    }

    public void reverseLinkedList(basicsLinkedLists list) {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and Remove Nth Node from End
    public void removeNthFromEnd(basicsLinkedLists list, int n) {
        Node prev = head;
        int i = size - n; // Index of the Prev Node
        if (n == size) {
            head = head.next;
            return;
        }
        for(int j = 1; j < i; j++) { // Traversing to the Prev Node of the Node to be Removed
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    // Check if the Linked List is a Palindrome (1221, 1441, racecar, etc) or not
    // Step 1. Find the Middle Node // 2 Cases: i). Even   ii). Odd
    // Step 2. Reverse the 2nd Half of the List
    // Step 3. Check if 1st Half == 2nd Half
    public boolean palindromeLL(basicsLinkedLists list) {
        // Edge Cases (1 Element, Empty LL)
        if (head == null || head.next == null) {
            return true;
        }
        // Step 1. Find the Middle Node
        Node middle = list.middleNode(list);

        // Step 2. Reverse the 2nd Half
        Node prev = null;
        Node curr = middle;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        // Step 3. Check for Equality in both Halves
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public Node middleNode(basicsLinkedLists list) { // Slow-Fast Approach (Slow Pointer goes by +1 & Fast Pointer goes by 2++)
        Node curr = head;
        Node slow = curr;
        Node fast = curr;
        while (fast != null && fast.next != null) { // 1st Condition is for Even Sized Linked Lists and 2nd is for Odd Sized LL
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        basicsLinkedLists list = new basicsLinkedLists();
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.add(3, 3);
        list.printLL(list);
        System.out.println("Size of the Linked List: " + list.size);
        System.out.println();
        System.out.println("Removed Element: " + list.removeFirst());
        list.printLL(list);
        System.out.println("Size of the Linked List: " + list.size);
        System.out.println();
        System.out.println("Removed Element: " + list.removeLast());
        list.printLL(list);
        System.out.println("Size of the Linked List: " + list.size);
        System.out.println();

        // Iterative Search
        System.out.println("Iterative Search for Key = 5 at index: " + list.iterativeSearch(list, 5));
        System.out.println();

        //Recursive Search
        System.out.println("Recursive Search for Key = 3 at index: " + list.recursiveSearch(list, head, 3));
        System.out.println();

        //Reversing a Linked List
        System.out.print("Linked List before reversing: ");
        list.printLL(list);
        list.reverseLinkedList(list);
        System.out.print("Linked List after reversing: ");
        list.printLL(list);
        System.out.println();
        list.reverseLinkedList(list);

        //Removing Nth Node from End
        System.out.print("Linked List before: ");
        list.printLL(list);
        list.removeNthFromEnd(list, 3);
        System.out.print("Linked List after: ");
        list.printLL(list);
        System.out.println();

        // Checking for Palindrome
        list.addLast(4);
        list.addLast(2);
        list.addLast(1);
        System.out.println(list.palindromeLL(list));
    }
}
