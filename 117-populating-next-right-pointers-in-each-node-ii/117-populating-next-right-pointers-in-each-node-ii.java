/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Node pre;
    public Node connect(Node root) {
        pre=null;
        int n=height(root);
        for(int i=0;i<n;i++){
            pre=null;
            travers(i,root);
        }
        return root;
    }
    private void travers(int k,Node root){
        if(root==null) return;
        if(k==0){
            if(pre!=null) pre.next=root;
            pre=root;
        }
        else{
            travers(k-1,root.left);
            travers(k-1,root.right);
        }
        
    }
    private int height(Node root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}