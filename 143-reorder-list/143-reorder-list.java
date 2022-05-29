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
        if(head.next==null) return;
        ListNode slow=head;
        ListNode fast=head.next;
        Stack<ListNode> s=new Stack<>();
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        while(slow.next!=null){
            s.push(slow.next);
            slow=slow.next;
        } 
        ListNode current=head;
        ListNode temp;
        while(!s.empty()){
            temp=current.next;
            current.next=s.pop();
            current.next.next=temp;
            current=temp;
        }
        current.next.next=null;
        
    }
}