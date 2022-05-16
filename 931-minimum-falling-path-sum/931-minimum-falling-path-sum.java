import java.util.Arrays;
class Solution {
    int[][] cache;
    int n;
    public int minFallingPathSum(int[][] matrix) {
        n=matrix.length;
        cache=new int[n][n];
        for (int[] row : cache)
            Arrays.fill(row, Integer.MAX_VALUE);
        int min=Integer.MAX_VALUE;
        int val;
        for(int i=0;i<n;i++){
            val=getMin(0,i,matrix);
            if(val<min) min=val;
        }
        return min;
    }
    
    public int getMin(int level,int col,int[][] matrix){
        if(level==n) return 0;
        if(cache[level][col]!=Integer.MAX_VALUE) return cache[level][col];
        
        int val1=Integer.MAX_VALUE;
        int val2=Integer.MAX_VALUE;
        int val3=Integer.MAX_VALUE;
        
        if(col>0) val1=matrix[level][col]+getMin(level+1,col-1,matrix);
        val2=matrix[level][col]+getMin(level+1,col,matrix);
        if(col<n-1) val3=matrix[level][col]+getMin(level+1,col+1,matrix);
        
        int newVal=Math.min(Math.min(val1,val2),val3);
        cache[level][col]=newVal;
        return newVal;
    }
}