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
        Stack<ListNode> stack= new Stack<>();
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        while(slow.next!=null){
            stack.push(slow.next);
            slow=slow.next;
        }
        
        ListNode current=head;
        ListNode temp;
        
        while(!stack.empty()){
            temp= current.next==null ? null: current.next;
            current.next=stack.pop();
            current.next.next=temp;
            current=temp;
        }
        
        current=current.next;
        current.next=null;
    }
}