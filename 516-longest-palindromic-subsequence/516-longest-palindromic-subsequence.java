import java.util.HashMap;  
class Solution {
    int[][] grid;
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        grid=new int[n][n];
        return findMax(0,n-1,s);
    }
    private int findMax(int i,int j,String s){
        if(i>j) return 0;
        if(grid[i][j]!=0) return grid[i][j];
        int val;
        if(i==j) return 1;
        if(s.charAt(i)==s.charAt(j)) {
            val=2+findMax(i+1,j-1,s);
            grid[i][j]=val;
            return val;
        }
        val=Math.max(findMax(i,j-1,s),findMax(i+1,j,s));
        grid[i][j]=val;
        return val;
    }
}