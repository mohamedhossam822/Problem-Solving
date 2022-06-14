class Solution {
    int[][] grid;
    public int minDistance(String word1, String word2) {
        grid=new int[word1.length()][word2.length()];
        return minDistance2(0,word1,0,word2);
    }
    public int minDistance2(int i,String word1,int j ,String word2){
        if(j==word2.length() && i==word1.length()) return 0;
        if(i==word1.length()) return word2.length()-j;
        if(j==word2.length()) return word1.length()-i;
        if(grid[i][j]!=0) return grid[i][j];
        if(word1.charAt(i)==word2.charAt(j)) {
            grid[i][j]=minDistance2(i+1,word1,j+1,word2);
        } 
        else grid[i][j]=1+Math.min(minDistance2(i+1,word1,j,word2),minDistance2(i,word1,j+1,word2));
        return grid[i][j];
    }
}