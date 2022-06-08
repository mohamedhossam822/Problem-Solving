class Solution {
    int[][] grid;
    public int countVowelStrings(int n) {
        grid=new int[5][n+1];
        int sum=0;
        for(int i=0;i<5;i++) sum+=countVowelStrings(i,n);
        return sum;
    }
     public int countVowelStrings(int i,int n){
         if(grid[i][n]!=0) return grid[i][n];
         if(n==1) grid[i][n]=1;
         else{
            int sum=0;
             for(int j=i;j<5;j++) sum+=countVowelStrings(j,n-1); 
             grid[i][n]=sum;
         }
         return grid[i][n];
     }
}