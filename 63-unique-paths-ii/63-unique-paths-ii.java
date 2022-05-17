class Solution {
    int[][] grid;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        grid=new int[m][n];
        grid[0][0]=1;
        return visit(m-1,n-1,obstacleGrid);   
    }
    public int visit(int i,int j,int[][] obstacleGrid){
        if(i<0 || j<0 || obstacleGrid[i][j]==1) return 0;
        if(grid[i][j]!=0) return grid[i][j];
        int val=visit(i-1,j,obstacleGrid)+visit(i,j-1,obstacleGrid);
        grid[i][j]=val;
        return val;
    }
}