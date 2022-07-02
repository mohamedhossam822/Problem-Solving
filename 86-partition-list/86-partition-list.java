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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        ListNode end=null;
        ListNode last=head;
        ListNode curr=head;
        ListNode pre=null;
        while(last.next!=null) last=last.next;
        while(curr!=end){
            if(curr.val>=x){
                
                
                
                //Make last point to this node , make it new last
                last.next=curr;
                last=last.next;
                
                ListNode temp=curr.next;
                
                last.next=null;
                //Define the end condition
                if(end==null) end=last;
                
                //Delete the node from its place
                if(pre!=null) pre.next=temp;
                else head=temp;
                
                curr=temp;
                
            }else{
                pre=curr;
                curr=curr.next; 
            }
            
        }
        
        return head;
    }
}