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
    int max;
    public int maxPathSum(TreeNode root) {
        max=-10001;
        getMax(root);
        return max;
    }
    public int getMax(TreeNode root) {
        if(root==null) return -10001;
        int val,left,right,val2;
        left=getMax(root.left);
        right=getMax(root.right);
        val=root.val>(root.val+left+right)? root.val : root.val+left+right;
        if(val>max) max=val;
        if(root.val>root.val+left && root.val>root.val+right){
            return root.val;
        }
        val2=Math.max(root.val+left,root.val+right);
        if(val2>max) max=val2;
        return val2;
        
    }
}