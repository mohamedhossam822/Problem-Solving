class Solution {
    int[][] dir;
    int m, n;

    public void solve(char[][] board) {
        m = board.length; //len of rows
        n = board[0].length; //len of cols
        dir = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        
        //Travers the outer rows and cols to look for an entrance
        for (int j = 0; j < n; j++) {
            //For each openning we populate with 'V'
            if (board[0][j] == 'O') dfs(0 ,j, board);
        }
        for (int j = 0; j < n; j++) {
            //For each openning we populate with 'V'
            if (board[m-1][j] == 'O') dfs(m-1, j, board);
        }
        for (int i = 1; i < m - 1; i++) {
            //For each openning we populate with 'V'
            if (board[i][0] == 'O') dfs(i, 0 ,board);
        }
        for (int i = 1; i < m - 1; i++) {
            //For each openning we populate with 'V'
            if (board[i][n-1] == 'O') dfs(i,n-1,board);
        }
        
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
    }

    public void dfs(int i, int j, char[][] board) {
        if (board[i][j] == 'V') return;
        board[i][j] = 'V';
        int x, y;
        //for each direction : visit if open
        for (int[] r : dir) {
            x = r[0] + i;
            y = r[1] + j;
            if (isValid(x, y) && board[x][y] == 'O') dfs(x, y, board);
        }
    }

    public boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        return true;
    }
}
