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
    public ListNode rotateRight(ListNode head, int k) {
        int size=0;
        ListNode current=head;
        
        //Get the size of list
        while(current!=null){
            size++;
            current=current.next;
        }
        if(size==0) return null;
        //Get the new starting node
        while(k>=size) k-=size;
        if(k==0) return head;
        k=size-k;
        
        //Seperate the old trail and the new trail 1,2,3 - 4,5
        ListNode res=head;
        ListNode pre=null;
        
        for(k=k;k>0;k--){
            pre=res;
            res=res.next; 
        } 
        
        pre.next=null;
        
        //make the last node in the new trail point to the old trail
        current=res;
        while(current.next!=null) current=current.next;
        current.next=head;
        
        return res;
    }
}