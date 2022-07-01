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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode SecondHalf=slow.next;
        slow.next=null;
        
        SecondHalf=reverseList(SecondHalf);
        
        while(head!=null && SecondHalf!=null){
            if(head.val!=SecondHalf.val) return false;
            head=head.next;
            SecondHalf=SecondHalf.next;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode pre=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }
    
}