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
    public ListNode middleNode(ListNode head) {
        ListNode root=head;
        ListNode fastRoot=head;
        while(fastRoot!=null && fastRoot.next!=null){
            root=root.next;
            fastRoot=fastRoot.next.next==null ? null : fastRoot.next.next;
        }
        
        return root;
    }
}