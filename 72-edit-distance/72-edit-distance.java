class Solution {
    int m,n;
    int[][] grid;
    public int minDistance(String word1, String word2) {
        m=word1.length();
        n=word2.length();
        grid=new int[m][n];
        return minDistance(0 ,word1 ,0 ,word2);
    }
    //Inserting  word i+1
    //Deleting  word 2 j+1
    //Replacing word i+1 , j+1
    private int minDistance(int i ,String word1 ,int j ,String word2){
        if(i==m) return n-j;
        if(j==n) return m-i;
        if(grid[i][j] !=0) return grid[i][j];
        if(word1.charAt(i)==word2.charAt(j))
            grid[i][j]=minDistance(i+1 ,word1 ,j+1 ,word2);
        else grid[i][j]=1+Math.min(Math.min(minDistance(i+1 ,word1 ,j ,word2),
                                       minDistance(i ,word1 ,j+1 ,word2)),minDistance(i+1 ,word1 ,j+1 ,word2));
        return grid[i][j];
    }
}