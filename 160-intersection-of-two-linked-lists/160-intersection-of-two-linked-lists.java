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
import java.io.*;
import java.util.*;
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        Hashtable<ListNode, Character > htA = new Hashtable<>();
        ListNode tempA=headA;
        
        while(tempA.next!=null){
            htA.put(tempA,' ');
            tempA=tempA.next;
        }
        htA.put(tempA,' ');
        
        ListNode tempB=headB;
        
        while(tempB!=null){
            if(htA.containsKey(tempB)){
                return tempB;
            }
            else if(tempB.next!=null) tempB=tempB.next;
            else tempB=null;
        }
        
        return null;
    }
}