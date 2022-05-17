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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        traverse(root,targetSum,new ArrayList<Integer>());
        return result;
    }
    private void traverse(TreeNode Node,int target,List<Integer> list){
        if(Node==null) return;
        target=target-Node.val;
        list.add(Node.val);
        if(target==0 && Node.right==null && Node.left==null){
            result.add(new ArrayList(list));
            return;
        }  
        traverse(Node.left,target,new ArrayList<>(list));
        traverse(Node.right,target,new ArrayList<>(list));
    }
}