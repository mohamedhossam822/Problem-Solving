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
    int counter=0;
    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        return sort(nums,0,len-1);
    }
    TreeNode sort(int[] nums,int l,int r){
        if(r<l) return null;
        TreeNode root=new TreeNode();
        int mid=l+(r-l)/2;
        root.val=nums[mid];
        root.left=sort(nums,l,mid-1);
        root.right=sort(nums,mid+1,r);
        return root;
    }
}