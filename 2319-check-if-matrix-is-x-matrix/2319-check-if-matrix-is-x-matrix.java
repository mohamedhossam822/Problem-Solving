class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n=grid.length-1;
        for(int i=0;i<=n;i++)
            for(int j=0;j<=n;j++){
                //Diagonal i==j || i+j=n
                if(i==j || i+j==n){
                  if(grid[i][j]==0) return false;  
                }
                //normal one
                else if(grid[i][j]!=0) return false;
            }
        return true;
    }
}