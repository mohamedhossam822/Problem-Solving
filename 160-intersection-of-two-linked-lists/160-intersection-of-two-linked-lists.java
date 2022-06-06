/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        HashSet<ListNode> set = new HashSet<>();
        ListNode tempA=headA;
        
        while(tempA.next!=null){
            set.add(tempA);
            tempA=tempA.next;
        }
        set.add(tempA);
        
        ListNode tempB=headB;
        
        while(tempB!=null){
            if(set.contains(tempB)){
                return tempB;
            }
            else if(tempB.next!=null) tempB=tempB.next;
            else tempB=null;
        }
        
        return null;
    }
}