/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
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
    boolean valid;
    int prev;
    boolean prevDef;
    public boolean isValidBST(TreeNode root) {
        valid=true;
        prevDef=false;
        inorder(root);
        return valid;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prevDef && prev>=root.val){
            valid=false;
            return;
        }
        prevDef=true;
        prev=root.val;
        inorder(root.right);
    }
}