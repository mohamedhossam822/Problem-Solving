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
    
    List <Node> nodes=new ArrayList<>();
    
    public Node connect(Node root) {
        if(root==null) return null;
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
        {
            traversByLevel(root, i);
        }
        nodes.get(0).next=null;
        int n=2;
        for(i=1; i<nodes.size(); i++){
            for(int j=0;j<n-1;j++){
                nodes.get(i).next=nodes.get(i+1);
                i++;
            }
            nodes.get(i).next=null;
            n=2*n;
        }
        return root;
    }
    
    private int height(Node root){
        if(root==null) return 0;
        else return height(root.left)+1;
    }
    
    private void traversByLevel(Node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            nodes.add(root);
        else if (level > 1)
        {
            traversByLevel(root.left, level-1);
            traversByLevel(root.right, level-1);
        }
    }
    
    
}

