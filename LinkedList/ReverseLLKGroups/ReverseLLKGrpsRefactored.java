package LinkedList.ReverseLLKGroups;

import LinkedList.ListNode;
import LinkedList.Pair;

public class ReverseLLKGrpsRefactored {
    class Solution {
        ListNode thead=null;
        ListNode ttail=null;
        ListNode mhead=null;
        ListNode mtail=null;
        public void addToTempList(ListNode curr){
            if (thead==null){
                thead=curr;
                ttail=curr;
                return;
            }
            curr.next=thead;
            thead=curr;
        }
        public void addTempListToMainList(){
            if (mhead==null){
                mhead=thead;
                mtail=ttail;
                return;
            }
            mtail.next=thead;
            mtail=ttail; 
        }
        public void makeTempListEmpty(){
            ttail=null;
            thead=null;
        }
        public Pair ReverseTempList(ListNode head){
            ListNode prev=null;
            ListNode curr=head;
            while(curr!=null){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            return new Pair(prev, head);
        }
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode curr=head;
            int cnt=k;
            while(curr!=null){
                ListNode next=curr.next;
                curr.next=null;
                addToTempList(curr);
                curr=next;
                cnt--;
                if (cnt==0){
                    addTempListToMainList();
                    makeTempListEmpty();
                    cnt=k;
                }
                
            }
            if (cnt!=k){
                Pair ll=ReverseTempList(thead);
                mtail.next=ll.start;
                mtail=ll.end;
            }
            
            return mhead;
        }
    }
}
