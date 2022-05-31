class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];
        char fCh=word.charAt(0);
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                if(fCh==board[i][j]){
                    visited=new boolean[board.length][board[0].length];
                    if(dfs(i,j,board,0,word)) return true;
                }
            }
        return false;
    }
    
    private boolean dfs(int i,int j,char[][] board,int index, String word){
        if(board[i][j]!=word.charAt(index)) return false;
        if(visited[i][j]) return false;
        if(word.length()-1==index) return true;
        visited[i][j]=true;
        if(i>0) if(dfs(i-1,j,board,index+1,word)) return true;
        if(j>0) if(dfs(i,j-1,board,index+1,word)) return true;
        if(i<board.length-1) if(dfs(i+1,j,board,index+1,word)) return true;
        if(j<board[0].length-1) if(dfs(i,j+1,board,index+1,word)) return true;
        visited[i][j]=false;
        return false;
    }
}