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
    List<List<TreeNode>> cache;
    public List<TreeNode> allPossibleFBT(int n) {
        cache=new ArrayList<>();
        for(int i=1;i<=n+1;i++){
            cache.add(null);
        }
        if(n%2==0) return new ArrayList<>();
        List<TreeNode> list=new ArrayList<>();
        list.add(new TreeNode(0));
        cache.set(1,list);
        
        return create(n); 
    }
    
    public List<TreeNode> create(int n) {
        if(cache.get(n)!=null) return cache.get(n);
        List<TreeNode> list=new ArrayList<>();
        for(int i=1;i<n-1;i+=2){
            TreeNode root=new TreeNode(0);
            for(TreeNode left: create(i)){
                root.left=left;
                for(TreeNode right: create(n-1-i)){
                    root.right=right;
                    TreeNode temp=new TreeNode(0,root.left,root.right);
                    list.add(temp);
                }
            }
        }
        cache.set(n,list);
        return list; 
    }
}