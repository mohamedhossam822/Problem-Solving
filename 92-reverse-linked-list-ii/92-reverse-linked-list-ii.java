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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start=null;
        ListNode end=null;
        ListNode curr=head;
        ListNode pre=null;
        int i=1;
        while(curr!=null){
            if(left-1==i) start=curr;
            if(right+1==i){
                end=curr;
                break;
            }
            i++;
            pre=curr;
            curr=curr.next;
        }
        if(start==null) curr=head;
        else{
            curr=start.next;
            start.next=pre;
        } 
        
        
        pre=end;
        
        while(curr!=end){
            ListNode temp=curr.next;
            curr.next=pre;
            if(temp==end && start==null) return curr;
            pre=curr;
            curr=temp;
        }
        
        return head;
        
    }
}