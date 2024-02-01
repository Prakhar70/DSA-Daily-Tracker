package LinkedList;

public class ReverseAddFirst {
    ListNode thead=null;
    public void addFirst(ListNode curr){
        if (thead==null){
            thead=curr;
            return;
        }
        curr.next=thead;
        thead=curr;
    }
    public ListNode reverseListIter(ListNode head) {
        
        ListNode curr=head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next=null;
            addFirst(curr);
            curr=next;
        }
        return thead;
    }
}
