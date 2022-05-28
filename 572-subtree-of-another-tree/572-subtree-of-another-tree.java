/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left54;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null && root==null) return true;
        if(root==null || subRoot==null) return false;
        boolean val;
        if(root.val==subRoot.val) {
            val=isSubtree2(root.left,subRoot.left) && isSubtree2(root.right,subRoot.right);
            if(val) return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    
     private boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if(subRoot==null && root==null) return true;
        if(root==null || subRoot==null) return false;
        if(root.val==subRoot.val) {
            return isSubtree(root.left,subRoot.left) && isSubtree(root.right,subRoot.right);
        }
        return false;
    }
}