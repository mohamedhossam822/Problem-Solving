class Solution {
    int mod=1000000007;
    Integer[][][] grid;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        grid=new Integer[m][n][maxMove+1];
        
        return dfs(m,n,maxMove,startRow,startColumn);
    }
    public int dfs(int m, int n, int maxMove, int startRow, int startColumn) {
        if(startRow==m || startColumn==n || startRow==-1 || startColumn==-1 ) return 1;
        if(maxMove==0)  return 0; 
        if(grid[startRow][startColumn][maxMove]!=null) return grid[startRow][startColumn][maxMove];
        int sum=0;
        sum+=dfs(m,n,maxMove-1,startRow,startColumn-1);
        sum%=mod;  
        sum+=dfs(m,n,maxMove-1,startRow-1,startColumn);
        sum%=mod;
        sum+=dfs(m,n,maxMove-1,startRow,startColumn+1);
        sum%=mod;
        sum+=dfs(m,n,maxMove-1,startRow+1,startColumn);
        grid[startRow][startColumn][maxMove]=sum%mod;
        return grid[startRow][startColumn][maxMove];
    }
}