package LinkedList.ReverseLL;

import LinkedList.ListNode;

public class Reverse {
    public ListNode reverseListIter(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode reverseListRecursive(ListNode head) {
        return reverseListRecursiveHelper(head).start;
    }
    public Pair reverseListRecursiveHelper(ListNode head) {
        if (head == null || head.next == null){
            return new Pair(head, head);
        }
        Pair p=reverseListRecursiveHelper(head.next);
        head.next=null;
        p.end.next=head;
        return new Pair(p.start, head);
    }
}
