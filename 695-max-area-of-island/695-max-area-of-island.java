class Solution {
    int[][] gridVisited;
    public int maxAreaOfIsland(int[][] grid) {
        int maxSum=0;
        gridVisited=new int[grid.length][grid[0].length];
        int sum=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && gridVisited[i][j]==0){
                    sum=calculateSum(grid,i,j);
                    if(sum>maxSum) maxSum=sum;
                }
            }
        }
        return maxSum;
    }
    
    private int calculateSum(int[][] grid,int i, int j){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1) return 0;
        if(grid[i][j]==0) return 0;
        if(gridVisited[i][j]==1) return 0; 
        gridVisited[i][j]=1;
        return 1+calculateSum(grid,i+1,j)+calculateSum(grid,i-1,j)+calculateSum(grid,i,j+1)+calculateSum(grid,i,j-1);
    }
    
}