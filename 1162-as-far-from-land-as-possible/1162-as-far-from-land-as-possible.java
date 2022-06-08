class Solution {
    int[][] maxDistance;
    int n,max;
    public int maxDistance(int[][] grid) {
        max=0;
        int val1,val2;
        n=grid.length;
        maxDistance=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) maxDistance[i][j]=1;
                else{
                    if(i>0 && maxDistance[i-1][j]>0) val1=  grid[i-1][j]==1 ?  1 : maxDistance[i-1][j]+1;
                    else val1=0;
                    if(j>0 && maxDistance[i][j-1]>0) val2=  grid[i][j-1]==1 ?  1 : maxDistance[i][j-1]+1;
                    else val2=0;
                    if(val1==0)  maxDistance[i][j]=val2;
                    else if(val2==0)  maxDistance[i][j]=val1;
                    else maxDistance[i][j]=Math.min(val1,val2);
                } 
            }
        int val3;
        for(int i=n-1;i>=0;i--)
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1) maxDistance[i][j]=1;
                else{
                    if(i<n-1 && maxDistance[i+1][j]>0) val1=  grid[i+1][j]==1 ?  1 : maxDistance[i+1][j]+1;
                    else val1=0;
                    if(j<n-1 && maxDistance[i][j+1]>0) val2=  grid[i][j+1]==1 ?  1 : maxDistance[i][j+1]+1;
                    else val2=0;
                    val3=0;
                    if(val1==0)  val3=val2;
                    else if(val2==0)  val3=val1;
                    else val3=Math.min(val1,val2);
                    if(val3!=0) {
                        if(maxDistance[i][j]==0)  maxDistance[i][j]=val3;
                        else  maxDistance[i][j]=Math.min(val3,maxDistance[i][j]);
                    }
                    if(maxDistance[i][j]>max) max=maxDistance[i][j];
                }
            }
        if(max==0) return -1;
        return max;
    }
}