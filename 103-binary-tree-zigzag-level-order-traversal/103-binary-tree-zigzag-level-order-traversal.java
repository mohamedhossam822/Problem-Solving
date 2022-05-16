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
    List<Integer> level=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        int n = findHeight(root);
        for(int i=0;i<n;i++){
            getLevel(i%2,i,root);
            result.add(level);
            level=new ArrayList<>();
        }
        return result;
    }
    
    public void getLevel(int left,int index,TreeNode root){
        if(root==null) return;
        if(index==0){
            level.add(root.val);
        }else{
            if(left==0){
                getLevel(left,index-1,root.left);
                getLevel(left,index-1,root.right);
            }else{
                getLevel(left,index-1,root.right);
                getLevel(left,index-1,root.left);
            }
        }
    }
    
    public int findHeight(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(findHeight(root.left),findHeight(root.right));
    }
}