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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key){
            root=fixtree(root);
            return root;
        } 
        TreeNode res=root;
        search(root,key);
        return res;
    }
    private void search(TreeNode root, int key){
        if(root==null) return;
        if(root.left!=null){
            if(root.left.val==key) {
                root.left=fixtree(root.left);
                return;
            }
            search(root.left,key);
        }
        if(root.right!=null){
            if(root.right.val==key) {
                root.right=fixtree(root.right);
                return;
            }
            search(root.right,key);
            
        }
    }
    private TreeNode fixtree(TreeNode root){
        int f;
        if(root.left==null & root.right==null) {
           return null; 
        }
        else if(root.left==null) return root.right;
        else if(root.right==null) return root.left;
        else{
            f=0;
            TreeNode node=root.right;
            TreeNode temp=root;
            while(node.left!=null){
                f=1;
                temp=node;
                node=node.left;
            } 
            root.val=node.val;
            if(f==1) temp.left=fixtree(node);
            else temp.right=fixtree(node);
            return root;
        }
    }
}