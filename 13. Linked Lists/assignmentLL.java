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
}
