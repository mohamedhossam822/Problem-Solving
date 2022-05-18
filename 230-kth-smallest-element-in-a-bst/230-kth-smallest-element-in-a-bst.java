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

import java.io.*;
import java.util.*;

class Solution {
    private int counter=0;
    private int index=-1;
    private boolean flag=true;
    
    public int kthSmallest(TreeNode root, int k) {
        traverseTree(root,k);
        return index;
    }
    
    public void traverseTree(TreeNode root,int k){
        if(root!=null)
        {
        if(flag) traverseTree(root.left,k);
        counter++;
        if(counter==k) {
            flag=false;
            index=root.val;
        }
        if(flag) traverseTree(root.right,k);  
        }
    }
}