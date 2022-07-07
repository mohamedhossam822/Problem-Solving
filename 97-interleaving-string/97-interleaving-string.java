class Solution {
    Boolean[][] grid;
    int s1Size,s2Size;
    public boolean isInterleave(String s1, String s2, String s3) {
        s1Size=s1.length();
        s2Size=s2.length();
        grid=new Boolean[s1Size+1][s2Size+1];
        
        return isInterleveled(0,s1,0,s2,0,s3);
    }
    
    public boolean isInterleveled(int i,String s1,int j, String s2,int k, String s3){
        if(k==s3.length() && i==s1Size && j==s2Size) return true;
        if(k==s3.length()) return false;
        if(grid[i][j]!=null) return grid[i][j];
        
        if(i<s1Size && s1.charAt(i)==s3.charAt(k) && j<s2Size && s2.charAt(j)==s3.charAt(k))
            grid[i][j]=isInterleveled(i+1,s1,j,s2,k+1,s3) || isInterleveled(i,s1,j+1,s2,k+1,s3);
        else if(i<s1Size && s1.charAt(i)==s3.charAt(k)) grid[i][j]=isInterleveled(i+1,s1,j,s2,k+1,s3);
        else if(j<s2Size && s2.charAt(j)==s3.charAt(k)) grid[i][j]=isInterleveled(i,s1,j+1,s2,k+1,s3);
        else grid[i][j]=false;
        
        return grid[i][j];  
    }
}