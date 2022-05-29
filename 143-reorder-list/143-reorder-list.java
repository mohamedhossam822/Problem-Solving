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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        //Divide the list//
        //Get the start of the second list
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow=slow.next;
        //Reverse the second part of the list
        ListNode temp,prev=null;
        while(slow!=null){
            temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        } 
        slow=prev;
        ListNode current=head;
        while(current!=null && slow!=null){
            temp=current.next;
            current.next=slow;
            slow=slow.next;
            current.next.next=temp;
            current=temp;
        }
        current.next=null;
        
    }
}