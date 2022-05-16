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

import java.util.Arrays;
 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        TreeNode result=new TreeNode();
        result.val=preorder[0];
        if(preorder.length==1) return result;
        int index= findIndex(inorder,preorder[0]);
        result.left=buildTree(Arrays.copyOfRange(preorder, 1, index+1),
                              Arrays.copyOfRange(inorder, 0, index));
        result.right=buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length),
                              Arrays.copyOfRange(inorder, index+1, inorder.length));
        return result;
    }
    public int findIndex(int[] inorder,int val){
        for(int i=0;i<inorder.length;i++){
            if(val==inorder[i]) return i;
        }
        return -1;
    }
}