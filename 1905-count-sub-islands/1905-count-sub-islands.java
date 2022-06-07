class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m=grid1.length;
        int n=grid1[0].length;
        int res=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && dfs(i,j,grid1,grid2,m,n)) res++;    
            }
        return res;
    }
    
    public boolean dfs(int i,int j,int[][] grid1,int[][] grid2,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n) return true;
        if(grid2[i][j]!=1) return true;
        boolean val=true,val1,val2,val3,val4;
        if(grid1[i][j]!=grid2[i][j]) val=false;
        grid2[i][j]=2;
        val1= dfs(i-1,j,grid1,grid2,m,n);
        val2= dfs(i,j-1,grid1,grid2,m,n);
        val3= dfs(i+1,j,grid1,grid2,m,n);
        val4= dfs(i,j+1,grid1,grid2,m,n);
        return val && val1 && val2 && val3 && val4;
    }
}