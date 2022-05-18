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
class BSTIterator {
    private int pointer;
    private ArrayList<Integer> tree;

    public BSTIterator(TreeNode root) {
        tree = new ArrayList<>();
        pointer=0;
        traverse(root);
        
    }
    private void traverse(TreeNode root){
        if(root!=null){
            traverse(root.left);
            tree.add(root.val);
            traverse(root.right);
        }
    }
    
    public int next() {
        return tree.get(pointer++);
    }
    
    public boolean hasNext() {
        return pointer<tree.size();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */