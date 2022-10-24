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
                    CoverIsland(i,j,grid);
                }
            }
        }
        
        return Nislands;
        
    }
    public void CoverIsland(int i,int j,char[][] grid)
    {
        if(grid[i][j]!='1') return;
        grid[i][j]='2';
        
        if(i>0) CoverIsland(i-1,j,grid);
        if(j<grid[i].length-1) CoverIsland(i,j+1,grid);
        if(j>0) CoverIsland(i,j-1,grid);
        if(i<grid.length-1) CoverIsland(i+1,j,grid);
    }
}