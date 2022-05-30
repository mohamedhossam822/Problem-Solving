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
        
        if(lists.length==0) return null;
        return divideAndSort(0,lists.length-1,lists);
    }
    private ListNode divideAndSort(int i,int j,ListNode[] lists){
        if(i==j) return lists[i];
        int mid=i+(j-i)/2;
        ListNode list1=divideAndSort(i,mid,lists);
        ListNode list2=divideAndSort(mid+1,j,lists);
        return mergeTwoLists(list1,list2);
        
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;

        ListNode Head = new ListNode();
        ListNode current = Head;

        while (true) {
            if (list1 != null && (list2 == null || list1.val <= list2.val)) {
                current.val = list1.val;
                if (list1.next != null) list1 = list1.next; else list1 = null;
            } else if (list2 != null && (list1 == null || list2.val < list1.val)) {
                current.val = list2.val;
                if (list2.next != null) list2 = list2.next; else list2 = null;
            }
            if (list1 == null && list2 == null) break; else {
                current.next = new ListNode();
                current = current.next;
            }
        }
        return Head;
    }
}