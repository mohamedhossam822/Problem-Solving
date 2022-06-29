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
        List<Integer> list=new ArrayList<>();
        ListNode res=new ListNode(0);
        ListNode curr=res;
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        int size=list.size();
        for(int i=0;i<size;i++){
            curr.next=new ListNode(list.get(i));  
            curr=curr.next;
        } 
        return res.next;
    }
}