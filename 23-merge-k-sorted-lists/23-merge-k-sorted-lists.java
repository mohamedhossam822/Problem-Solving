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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=new ListNode();
        ListNode current=res;
        int minIndex,n=lists.length;
        boolean found;
        while(true){
            found=false;
            minIndex=0;
            for(int i=0;i<n;i++){
                if(found){
                    if(lists[i]!=null && lists[i].val<lists[minIndex].val) minIndex=i;
                }
                else{
                    if(lists[i]!=null){
                        minIndex=i;
                        found=true;
                    }  
                }
            }
            if(!found) break;
            current.next=new ListNode(lists[minIndex].val);
            current=current.next;
            lists[minIndex]=lists[minIndex].next;
            
        }
        return res.next;
    }
}