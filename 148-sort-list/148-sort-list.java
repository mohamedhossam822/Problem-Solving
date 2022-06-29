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
    public ListNode sortList(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        ListNode list1=sortList(head);
        ListNode list2=sortList(fast);
        return merge(list1,list2);
    }
    
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode l1,l2;
        if(list1.val<=list2.val) {
            l1=list1;
            l2=list2;
        }
        else {
            l1=list2;
            l2=list1;
        }
        ListNode res=l1;
        ListNode temp =l1;
        
        while (l1!=null || l2!=null) {
            if(l1==null) {
                temp.next=l2;
                break;
            }
            if(l2==null) {
                temp.next=l1;
                break;
            }
            if(l1.val<=l2.val){
                temp=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                temp=l2;
                l2=l1;
                l1=temp;
            }
        }
        return res;
    }
}