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
        if(head==null) return null;
        ListNode reversedList=new ListNode();
        ListNode temp=null;
        while(head!=null){
            reversedList=new ListNode(head.val);
            reversedList.next=temp;
            temp=reversedList;
            head=head.next ==null ? null: head.next;
        }
        return reversedList;
    }
}