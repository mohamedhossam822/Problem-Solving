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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        int cInserted=0;
        ListNode dummy=new ListNode();
        ListNode current=dummy;
        while(head!=null){
            cInserted=0;
            for(int i=0;i<k;i++){
                stack.push(head);
                cInserted++;
                if(head.next==null) {
                    head=null;
                    break;
                }
                else head=head.next;
            }
            while(cInserted==k &&!stack.empty()){
                current.next=stack.pop();
                current=current.next;
            }
            if(cInserted<k){
                Stack<ListNode> Tempstack = new Stack<>();
                while(!stack.empty()) Tempstack.push(stack.pop());
                while(!Tempstack.empty()){
                    current.next=Tempstack.pop();
                    current=current.next;
                }
            }
        }
        current.next=null;
        return dummy.next;
    }
}