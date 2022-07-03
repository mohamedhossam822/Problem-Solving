class Solution {
    int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int m,n;
    public int countPaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        long[][] cache=new long[m][n];
        
        long sum=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                sum+=dfs(i,j,grid,cache);
                sum%=1000000007;
            }
                
        return (int)sum;
    }
    
    private long dfs(int i,int j,int[][] grid,long[][] cache){
        if(cache[i][j]!=0) return cache[i][j];
        long sum=1;
        for(int[] dim:dir){
            int x=dim[0]+i;
            int y=dim[1]+j;
            if(x<0 || y<0 || x>=m || y>=n) continue;
            if(grid[x][y]>grid[i][j]) {
                sum+=dfs(x,y,grid,cache);
                sum%=1000000007;
            }
        }
        cache[i][j]=sum;
        return sum%1000000007;
    }
}