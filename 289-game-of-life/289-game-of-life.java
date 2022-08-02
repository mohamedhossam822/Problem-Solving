class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dirs=new int[][]{{-1,-1},{0,-1},{1,-1},
                           {-1,0},{1,0},
                           {-1,1},{0,1},{1,1}};
        int m=board.length;
        int n=board[0].length;
        int[][] result=new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                int live=0;
                for(int[] dir:dirs){
                    int x=i+dir[0];
                    int y=j+dir[1];
                    if(x<0 || y<0 || x>=m || y>=n) continue;
                    if(board[x][y]==1) live++;
                    if(live>3 && board[i][j]==1){
                        result[i][j]=0;
                        break;
                    } 
                }
                if(live==3 && board[i][j]==0) result[i][j]=1;
                if(live<2 && board[i][j]==1) result[i][j]=0;
                if((live==2 || live==3) && board[i][j]==1) result[i][j]=1;
            }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) board[i][j]=result[i][j];
    }
}