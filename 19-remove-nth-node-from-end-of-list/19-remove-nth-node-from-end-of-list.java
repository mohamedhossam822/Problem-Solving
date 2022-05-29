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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current=head;
        ListNode fastRoot=head;
        for(int i=0;i<n;i++){
            fastRoot=fastRoot.next;
        }
        ListNode prev=null;
        while(fastRoot!=null){
            fastRoot=fastRoot.next;
            prev=current;
            current=current.next;
        }
        if(prev==null) return head.next;
        prev.next=current.next;
        
        return head;
        
    }
}