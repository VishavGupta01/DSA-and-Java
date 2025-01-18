import java.lang.classfile.components.ClassPrinter.ListNode;

public class assignmentLL {
    public static void main(String[] args) {

    }

    // Q1. Intersection of Two Linked Lists In a system there are two singly linked list. By some programming error,the end node of one of the linked lists got linked to the second list, forming an inverted Y - shaped list. Write a program to get the point where two linked lists merge.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            if(a == null) a = headB;
            else a = a.next;

            if(b == null) b = headA;
            else b = b.next;
        }
        return a;
    }

    // Q2. Delete N Nodes After M Nodes of a Linked List We have a linked list and two integers M and N.Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same till end of the linked list. Difficulty Level : Rookie.
    public ListNode deleteNodes(int n, int m, ListNode head) {
        Node temp = head;
        while(temp != null) {
            for(int i = 1; i < m && temp != null; i++) temp = temp.next;
            if(temp == null) break;
            Node next = temp;
            for(int i = 0; i < n && next != null; i++) next = next.next;
            temp.next = next;
            temp = next;
        }
        return head;
    }

    // Q3. Swapping Nodes in a Linked List We have a linked list and two keys in it, swap nodes for two given keys.Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields. It may be assumed that all keys in the linked list are distinct.
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return head;
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        int k2 = size - k + 1;
        ListNode start = head;
        ListNode end = head;
        for(int i = 1; i < k; i++) start = start.next;
        for(int i = 1; i < k2; i++) end = end.next;
        int t = start.val;
        start.val = end.val;
        end.val = t;
        return head;
    }
}
