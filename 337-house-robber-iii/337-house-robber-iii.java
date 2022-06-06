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
    public int rob(TreeNode root) {
        return getMax(root).up;   
    }
    
    //get the max upper and bottom value for each path
    private MaxPath getMax(TreeNode root){
        if(root==null) return new MaxPath(0,0);
        
        MaxPath left=getMax(root.left);
        MaxPath right=getMax(root.right);
        
        //New object either the max value is root + the 2 second ones or both of the first ones
        int down=left.up+right.up;
        int up=Math.max(down,root.val+left.down+right.down);
        
        return new MaxPath(up,down);
    }
    
    //A class to save the up and down for each path
    private class MaxPath{
        int up;
        int down;
        MaxPath(int up,int down){
            this.up=up;
            this.down=down;
        }
    }
}