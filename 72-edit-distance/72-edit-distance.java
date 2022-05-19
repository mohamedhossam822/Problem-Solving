class Solution {
    int m,n;
    int[][] grid;
    public int minDistance(String word1, String word2) {
        m=word1.length();
        n=word2.length();
        grid=new int[m][n];
        return getMin(0,word1,0,word2);
    }
    private int getMin(int i,String text1,int j,String text2){
        if(i==m && j==n) return 0;
        if(i==m)    return n-j;
        if(j==n)    return m-i;
        if(grid[i][j]!=0) return grid[i][j];
        int val;
        if(text1.charAt(i)==text2.charAt(j)){
            val=getMin(i+1,text1,j+1,text2);
            grid[i][j]=val;
            return val;
        }
        val=1+Math.min(Math.min(getMin(i,text1,j+1,text2),getMin(i+1,text1,j,text2))
                ,getMin(i+1,text1,j+1,text2));
        grid[i][j]=val;
        return val;
    }
}