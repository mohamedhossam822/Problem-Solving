class Solution {
    public int numIslands(char[][] grid) {
        int i,j;
        int Nislands=0;
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    Nislands++;
                    this.CoverIsland(i,j,grid);
                }
            }
        }
        
        return Nislands;
        
    }
    public void CoverIsland(int i,int j,char[][] grid)
    {
        try{
            if(grid[i][j]=='1')
                grid[i][j]='2';
            else return;
        }
        catch(Exception e){
            return;
        }
        
        CoverIsland(i-1,j,grid);
        CoverIsland(i,j+1,grid);
        CoverIsland(i,j-1,grid);
        CoverIsland(i+1,j,grid);
    }
}