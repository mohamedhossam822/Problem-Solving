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
    public ListNode reverseList(ListNode head) {
        ListNode prev,temp=head;
        prev=null;
        while(temp!=null){
            temp =head.next;
            head.next=prev;
            prev=head;
            if(temp!=null)
            head=temp;
        }
        return head;
    }
}