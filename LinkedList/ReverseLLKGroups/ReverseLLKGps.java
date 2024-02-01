package LinkedList.ReverseLLKGroups;
import java.util.List;

import LinkedList.ListNode;
public class ReverseLLKGps {
    ListNode mhead;
    ListNode mtail;
    ListNode thead;
    ListNode ttail;
    public ListNode reverseList(ListNode head) {
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int cnt=k;
        ListNode curr=head;
        while(curr!=null){
            
            ListNode next=curr.next;
            curr.next=null;
            addFirstToTemp(curr);
            curr=next;
            cnt--;
            if (cnt==0){
                cnt=k;
                addTemptoMain();
                thead=null;
                ttail=null;
            }

        }
        if (cnt>0){
            mtail.next=reverseList(thead);
            
        }
        return mhead;
    }
    public void addFirstToTemp(ListNode curr){
        if (thead==null){
            thead=curr;
            ttail=curr;
            return;
        }
        curr.next=thead;
        thead=curr;
    }
    public void addTemptoMain(){
        
        if (mhead==null){
            mhead=thead;
            mtail=ttail;
            return;
        }
        mtail.next=thead;
        mtail=ttail;
    }
    
}
