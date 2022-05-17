class Solution {
    int m,n;
    int[][] mat;
    
    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        mat=new int[m][n];
        return findMin(0,0,grid);
    }
    public int findMin(int i,int j,int[][] grid){
        if(j>=n || i>=m) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1) return grid[i][j];
        if(mat[i][j]!=0) return mat[i][j];
        int val=grid[i][j]+Math.min(findMin(i+1,j,grid),findMin(i,j+1,grid));
        mat[i][j]=val;
        return val;
    }
}