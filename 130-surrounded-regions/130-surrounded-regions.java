class Solution {
    int m, n;

    public void solve(char[][] board) {
        m = board.length; //len of rows
        n = board[0].length; //len of cols
        
        //Travers the outer rows and cols to look for an entrance
        for (int j = 0; j < n; j++) {
            //For each openning we populate with 'V'
            if (board[0][j] == 'O') dfs(0 ,j, board);
            if (board[m-1][j] == 'O') dfs(m-1, j, board);
        }
        for (int i = 1; i < m - 1; i++) {
            //For each openning we populate with 'V'
            if (board[i][0] == 'O') dfs(i, 0 ,board);
            if (board[i][n-1] == 'O') dfs(i,n-1,board);
        }
        
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
    }

    public void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'V';
        dfs(i, j-1, board);
        dfs(i, j+1, board);
        dfs(i-1, j, board);
        dfs(i+1, j, board);
    }
}
