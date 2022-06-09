class Solution {
    int n;
    public int shortestBridge(int[][] grid) {
        n=grid.length;
        boolean islandFound=false;
        int min=Integer.MAX_VALUE;
        List<int[]> island1=new ArrayList<>();
        List<int[]> island2=new ArrayList<>();
        //dfs to search for an island & insert every point in a list
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1) {
                    if(!islandFound){
                        dfs(i,j,grid,island1);
                        islandFound=true;
                    }
                    dfs(i,j,grid,island2);
                }
        
        //island 1 (0,1)
        //island (1,0)
        //preform a on each point to island 2 
        int x2,y2;
        for(int i=0;i<island1.size();i++){
            int x1=island1.get(i)[0];
            int y1=island1.get(i)[1];
            for(int j=0;j<island2.size();j++){
                x2=island2.get(j)[0];
                y2=island2.get(j)[1];
                min=Math.min(min,Math.abs(x2-x1)+Math.abs(y2-y1));
            }
        }
        return min-1;
    }
    private void dfs(int i,int j,int[][] grid, List<int[]> island){
        if(i<0 || j<0 || i>n-1 || j>n-1) return;
        if(grid[i][j]!=1) return;
        //Mark as visited
        grid[i][j]=2;
        island.add(new int[]{i,j});
        dfs(i,j-1,grid,island);
        dfs(i-1,j,grid,island);
        dfs(i,j+1,grid,island);
        dfs(i+1,j,grid,island);
    }
}