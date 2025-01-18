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
}
