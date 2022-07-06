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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res=null;
        
        int s1=0;
        int s2=0;
        
        ListNode curr=l1;
        while(curr!=null){
            curr=curr.next;
            s1++;
        }
        
        curr=l2;
        while(curr!=null){
            curr=curr.next;
            s2++;
        }
        
        for(int i=0;i<s1-s2;i++){
            ListNode node=new ListNode(l1.val);
            l1=l1.next;
            node.next=res;
            res=node;
        }
        
        for(int i=0;i<s2-s1;i++){
            ListNode node=new ListNode(l2.val);
            l2=l2.next;
            node.next=res;
            res=node;
        }
        
        
        while(l1!=null || l2!=null ){
            ListNode node=new ListNode(l1.val+l2.val);
            l1=l1.next;
            l2=l2.next;
            node.next=res;
            res=node;
        }
        
        ListNode pre=null;
        int reminder=0;
        while(res!=null){
            int val=reminder+res.val;
            reminder=val/10;
            res.val=val%10;
            
            ListNode next=res.next;
            res.next=pre;
            pre=res;
            if(next==null) break;
            res=next;
        }
        if(reminder==1){
            ListNode node=new ListNode(1);
            node.next=res;
            res=node;
        }
        return res;
    }
}