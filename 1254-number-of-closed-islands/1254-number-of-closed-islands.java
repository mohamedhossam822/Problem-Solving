class Solution {
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //populate any land in the edge as its not an island
        for(int i=0;i<m;i++){
            if(grid[i][0]==0) dfs(i,0,grid,m,n);
            if(grid[i][n-1]==0) dfs(i,n-1,grid,m,n);
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==0) dfs(0,j,grid,m,n);
            if(grid[m-1][j]==0) dfs(m-1,j,grid,m,n);
        }
        
        //if there is any land that wasn't populated then that means that its surrounded by water
        //As you can reach it from the edge
        int counter=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    counter++;
                    dfs(i,j,grid,m,n);
                } 
            }
            
        }
        return counter;
    }
    
    //populate visited lands
    public void dfs(int i,int j,int[][] grid,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n) return;
        if(grid[i][j]!=0) return;
        grid[i][j]=2;
        dfs(i-1,j,grid,m,n);
        dfs(i,j-1,grid,m,n);
        dfs(i+1,j,grid,m,n);
        dfs(i,j+1,grid,m,n);
    }
}