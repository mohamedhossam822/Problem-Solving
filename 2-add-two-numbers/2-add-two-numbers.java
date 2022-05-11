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
import java.util.ArrayList;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        int reminder=0;
        int l1Val=0;
        int l2Val=0;
        ListNode Result=new ListNode();
        ListNode currentSum=Result;
        while(true){
            if (l1==null) l1Val=0;
            else l1Val=l1.val;
            if (l2==null) l2Val=0;
            else l2Val=l2.val;
            sum=l1Val+l2Val+reminder;
            reminder=sum/10;
            sum=sum%10;
            currentSum.val=sum;
            if (l1==null || l1.next==null) l1=null;
            else l1=l1.next;
            if (l2==null || l2.next==null) l2=null;
            else l2=l2.next;
            if (l1!=null || l2!=null || reminder==1)
            {
                currentSum.next=new ListNode();
                currentSum=currentSum.next;
            }
            else break;
            
        }
        
        return Result;
    }
    
}

