class Solution {

    public int maxDistance(int[][] grid) {
        int max = 0;
        int val1, val2;
        int n = grid.length;
        int[][] minDistance = new int[n][n];

        //Check the min between the top and the left cell
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) minDistance[i][j] = 1; 
                else {
                    if (i > 0 && minDistance[i - 1][j] > 0) val1 = minDistance[i - 1][j] + 1; 
                    else val1 = 201;
                    if (j > 0 && minDistance[i][j - 1] > 0) val2 = minDistance[i][j - 1] + 1; 
                    else val2 = 201;
                    minDistance[i][j] = Math.min(val1, val2);
                }
            }
        //Check the min between the bottom and the right cell
        for (int i = n - 1; i >= 0; i--) 
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) minDistance[i][j] = 1; 
                else {
                    if (i < n - 1 && minDistance[i + 1][j] > 0) val1 = minDistance[i + 1][j] + 1; else val1 = 201;
                    if (j < n - 1 && minDistance[i][j + 1] > 0) val2 = minDistance[i][j + 1] + 1; else val2 = 201;
                    minDistance[i][j] = Math.min(Math.min(val1, val2), minDistance[i][j]);
                    if (minDistance[i][j] > max) max = minDistance[i][j];
                }
            }
        if (max >= 201) return -1;
        return max - 1;
    }
}
