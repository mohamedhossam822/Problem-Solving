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
        ListNode res=null;
        ListNode prev=null;
        
        boolean reverse=true;
        
        while(head!=null){
            
            ListNode fast=head;
            reverse=true;
            for(int i=0;i<k;i++){
                if(fast==null){
                    reverse=false;
                    break;
                }
                fast=fast.next;
            }
            ListNode slow=head;
            ListNode last=prev;
            prev=null;
            if(reverse)
            {
                while(head!=fast){
                    ListNode next=head.next;
                    head.next=prev;
                    prev=head;
                    head=next;
                    System.out.print(prev.val);
                }

                if(res==null) res=prev;
                else last.next=prev;

                prev=slow;
            }
            else{
                last.next=head;
                break;
            }
            
        }
        return res;
    }
}