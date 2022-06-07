class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //Search in row edges
        for(int j=0;j<n;j++){
            if(grid[0][j]==1) dfs(0,j,grid,m,n);
            if(grid[m-1][j]==1) dfs(m-1,j,grid,m,n);
        }
        //Search in col edges
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) dfs(i,0,grid,m,n);
            if(grid[i][n-1]==1) dfs(i,n-1,grid,m,n);
        }
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) sum+=dfs(i,j,grid,m,n);
            }
        }
        return sum;
    }
    
    public int  dfs(int i,int j,int[][] grid,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n) return 0;
        if(grid[i][j]!=1) return 0;
        int sum=1;
        grid[i][j]=2;
        sum+=dfs(i-1,j,grid,m,n);
        sum+=dfs(i,j-1,grid,m,n);
        sum+=dfs(i+1,j,grid,m,n);
        sum+=dfs(i,j+1,grid,m,n);
        return sum;
    }
    
}