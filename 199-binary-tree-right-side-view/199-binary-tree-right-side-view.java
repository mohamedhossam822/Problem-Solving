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
import java.util.*;   
class Solution {
    List<Integer> res;
    int n;
    public List<Integer> rightSideView(TreeNode root) {
        n=height(root);
        res=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            res.add(0);
        }
        for(int i=0;i<n;i++){
            traverse(i,i,root);
        }
        
        return res;
    }
    
    public void traverse(int k,int index,TreeNode root){
        if(root==null) return;
        if(index==0){
            res.set(k,root.val);
        }else{
            traverse(k,index-1,root.left);
            traverse(k,index-1,root.right);
        }
    }
    
    private int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}