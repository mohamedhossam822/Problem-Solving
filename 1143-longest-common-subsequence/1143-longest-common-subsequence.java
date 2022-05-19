class Solution {
    int n,m;
    int[][] grid;
    public int longestCommonSubsequence(String text1, String text2) {
        n=text1.length();
        m=text2.length();
        grid=new int[n][m];
        return getMax(0,text1,0,text2);
        
    }
    private int getMax(int i,String text1,int j,String text2){
        if(i==n || j==m) return 0;
        if(grid[i][j]!=0) return grid[i][j];
        int val;
        if(text1.charAt(i)==text2.charAt(j)){
            val=1+getMax(i+1,text1,j+1,text2);
            grid[i][j]=val;
            return val;
        }
        else{
            val=Math.max(
                getMax(i,text1,j+1,text2),
                getMax(i+1,text1,j,text2));
            grid[i][j]=val;
            return val;
        }
    }
}