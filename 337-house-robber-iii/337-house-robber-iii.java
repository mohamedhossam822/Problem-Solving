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
    List<Integer> list=new ArrayList<>();
    public int rob(TreeNode root) {
        return getMax(root).up;   
    }
    
    private MaxPath getMax(TreeNode root){
        if(root==null) return new MaxPath(0,0);
        MaxPath left=getMax(root.left);
        MaxPath right=getMax(root.right);
        
        int down=left.up+right.up;
        int up=Math.max(down,root.val+left.down+right.down);
        return new MaxPath(up,down);
    }
    private class MaxPath{
        int up;
        int down;
        MaxPath(int up,int down){
            this.up=up;
            this.down=down;
        }
    }
}