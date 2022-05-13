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
    public ListNode swapPairs(ListNode head) {
        ListNode result=new ListNode();
        result.next=head;
        ListNode current=result;
        while(head!=null && head.next!=null){
            current.next=head.next;
            if(head.next.next==null) head.next=null;
            else head.next=head.next.next;
            current.next.next=head;
            current=current.next.next;
            head=head.next;
        }
       return result.next; 
    }
}