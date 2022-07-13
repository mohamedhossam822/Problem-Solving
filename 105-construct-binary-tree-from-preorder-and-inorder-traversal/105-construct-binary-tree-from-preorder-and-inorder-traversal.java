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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return buildTree(0,n,preorder,0,n,inorder);
    }
    public TreeNode buildTree(int pStart,int pEnd,int[] preorder,int iStart,int iEnd, int[] inorder) {
        if(pStart==pEnd) return null;
        int val=preorder[pStart];
        TreeNode root=new TreeNode(val);
        int k=0;
        for(int i=iStart;i<iEnd;i++){
            if(val==inorder[i]) break;
            k++;
            
        }
        root.left=buildTree(pStart+1,pStart+k+1,preorder,iStart,iStart+k,inorder);
        root.right=buildTree(pStart+k+1,pEnd,preorder,iStart+k+1,iEnd,inorder);
        return root;
    }
}