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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list;
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode temp;
        int n;
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            n=q.size();
            list=new ArrayList<>(n);
            for(int i=0;i<n;i++){
                temp=q.poll();
                list.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            result.add(list);
        }
        return result;
    }
}