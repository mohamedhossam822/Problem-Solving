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
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        LinkedHashMap<Integer,Integer> ht=new LinkedHashMap<>();
        ListNode current=head;
        
        while(current!=null){
            if(ht.containsKey(current.val)){
                ht.put(current.val,-1);
            }
            else ht.put(current.val,1);
            current= current.next==null ? null : current.next;
        }
        
        Set<Entry<Integer, Integer> > entrySet= ht.entrySet();
        Iterator<Entry<Integer, Integer> > itr= entrySet.iterator();
        ListNode result=new ListNode();
        ListNode temp=result;
        current=result;
        
         while (itr.hasNext()) {
            Entry<Integer, Integer> entry = itr.next();
            if(entry.getValue()==1){
                current.val=entry.getKey();
                temp=current;
                current.next=new ListNode();
                current=current.next;
            }
        };
        
        if(temp.next==null) return null;
        temp.next=null;
        return result;
        
    }
}