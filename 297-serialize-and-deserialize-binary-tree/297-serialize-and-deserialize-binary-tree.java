/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res=new StringBuilder();
        encode(res,root);
        System.out.println(res);
        return res.toString();
    }
    private void encode(StringBuilder res,TreeNode root){
        if(root==null) res.append('n');
        else{
            res.append(" "+Integer.toString(root.val));
            encode(res,root.left);
            encode(res,root.right);
        } 
        
    }
    // Decodes your encoded data to tree.
    int counter;
    public TreeNode deserialize(String data) {
        counter=0;
        TreeNode res=decode(data);
        return res;
    }
    
    private TreeNode decode(String data){
        if(data.charAt(counter)=='n'){
            counter++;
            return null;
        } 
        else{
            int index=counter+1;
            while(data.charAt(index)!='n' && data.charAt(index)!=' ') index++;
            String temp=data.substring(counter+1, index);
            TreeNode root=new TreeNode(Integer. parseInt(temp));
            counter=index;
            root.left=decode(data);
            root.right=decode(data);
            return root;
        } 
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));