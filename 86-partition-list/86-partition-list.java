/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode before=new ListNode(0);
        ListNode res=before;
        
        ListNode after=new ListNode(0);
        ListNode afterRes=after;
        
        ListNode curr=head;
        while(curr!=null){
            if(curr.val>=x){
                after.next=curr;
                curr=curr.next;
                after=after.next;
                after.next=null;
            }else{
                before.next=curr;
                curr=curr.next;
                before=before.next;
                before.next=null;
            }
            
        }
        before.next=afterRes.next;
        
        return res.next;
    }
}