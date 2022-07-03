/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix=new int[m][n];
        int startRow=0,endRow=m;
        int startCol=0,endCol=n;
        
        while(startCol<endCol && startRow<endRow){
            
            for(int i=startCol;i<endCol;i++){
                if(head!=null) {
                    matrix[startRow][i]= head.val;
                    head=head.next;
                } else matrix[startRow][i]= -1;
            } 
            
            startRow++;
            endCol--;
            
            for(int i=startRow;i<endRow;i++){
                if(head!=null){
                    matrix[i][endCol]= head.val;
                    head=head.next;
                } else matrix[i][endCol]= -1;
            }
            
            endRow--;
            
            if(endRow<startRow) break;
            
            for(int i=endCol-1;i>=startCol;i--){
                if(head!=null){
                    matrix[endRow][i]= head.val;
                    head=head.next;
                } else matrix[endRow][i]= -1;
                
            } 
            
            if(startCol>=endCol) break;
            for(int i=endRow-1;i>=startRow;i--){
                if(head!=null){
                    matrix[i][startCol]= head.val;
                    head=head.next;
                } else matrix[i][startCol]= -1;
                
            }  
            startCol++;
        }
        return matrix;
    }
}