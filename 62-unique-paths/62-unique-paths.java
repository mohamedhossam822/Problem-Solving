import java.util.HashMap; 
class Solution {
    int[][] grid;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        grid=new int[m][n];
        grid[0][0]=1;
        return visit(m-1,n-1);   
    }
    public int visit(int i,int j){
        if(i<0 || j<0) return 0;
        if(grid[i][j]!=0) return grid[i][j];
        int val=visit(i-1,j)+visit(i,j-1);
        grid[i][j]=val;
        return val;
    }
}