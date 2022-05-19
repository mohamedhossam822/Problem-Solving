/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Stack<Integer> s=new Stack<Integer>();
        search(s,root,p);
        
        Stack<Integer> s2=new Stack<Integer>();
        search(s2,root,q);
        
        Iterator value = s.iterator();
        Iterator value2 = s2.iterator();
        
        int res=0,temp;
        while (value.hasNext() && value2.hasNext()) {
            temp=(int)value.next();
            if(temp==(int)value2.next()) res=temp;
            else break;
        }
        return new TreeNode(res);
    }
    public boolean search(Stack<Integer> s,TreeNode root, TreeNode p){
        if(root==null) return false;
        if(p.val==root.val){
            s.push(root.val);
            return true;
        }
        s.push(root.val);
        if(search(s,root.right,p) || search(s,root.left,p)) return true;
        else {
            s.pop();
            return false;
        }
        
    }
}