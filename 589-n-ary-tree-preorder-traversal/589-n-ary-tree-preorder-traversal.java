/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        
        List<Integer>  result=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        if(root==null) return result;
        stack.add(root);
        
        while(!stack.isEmpty()){
            
            Node current=stack.pop();
            
            result.add(current.val);
            List<Node> children=current.children;
            
            for(int i=children.size()-1;i>=0;i--) stack.push(children.get(i));
        }
        
        return result;
    }
}