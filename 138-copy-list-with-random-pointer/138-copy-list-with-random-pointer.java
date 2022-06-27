/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node,Node> OldNew=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        if(OldNew.containsKey(head)) return OldNew.get(head);
        Node res=new Node(head.val);
        OldNew.put(head,res);
        res.next=copyRandomList(head.next);
        res.random=copyRandomList(head.random);
        return res;
        
    }
}