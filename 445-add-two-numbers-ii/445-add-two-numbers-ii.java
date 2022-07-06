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
    int reminder=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        
        ListNode res=null;
        int reminder=0;
        int val=0;
        
        while(l1!=null || l2!=null ){
            
            if(l1==null){
                val=l2.val+reminder;
                l2=l2.next;
            } 
            else if(l2==null){
                val=l1.val+reminder;
                l1=l1.next;
            } 
            else{
               val=l1.val+l2.val+reminder; 
                l1=l1.next;
                l2=l2.next;
            }
            reminder=0;
            if(val>9) reminder=1;
            val%=10;
            
            ListNode node=new ListNode(val);
            node.next=res;
            res=node;
        }
        if(reminder==1){
            ListNode node=new ListNode(reminder);
            node.next=res;
            res=node;
        }
        return res;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            if(next==null) return head;
            head=next;
        }
        return null;
    }
}