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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        
        for(k=k;k>0;k--){
            fast=fast.next;
            if(fast==null) fast=head;
        }
        if(fast==null || fast==head) return head;
        ListNode preSlow=null;
        ListNode preFast=null;
        while(fast!=null){
            preSlow=slow;
            slow=slow.next;
            preFast=fast;
            fast=fast.next;
        }
        preSlow.next=null;
        preFast.next=head;
        
        return slow;
    }
}