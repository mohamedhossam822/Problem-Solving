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
        ListNode prev,temp;
        prev=null;
        while(head!=null){
            temp =head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        head=prev;
        return head;
    }
}