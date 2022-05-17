class Solution {
    int n,m;
    public int maximalSquare(char[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int max=0;
        int val=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    val=getMax(i,j,matrix);
                    if(val>max) max=val;
                }
            }
        }
        return max*max;
    }
    
    private int getMax(int i,int j,char[][] matrix){
        int intial=1;
        int f=0;
        while(true){
            if(i+intial>=n || j+intial>=m) break;
            if(matrix[i+intial][j+intial]!='1') break;
            for(int k=i;k<i+intial;k++){
                if(matrix[k][j+intial]!='1') f=1;
            }
            for(int k=j;k<j+intial;k++){
                if(matrix[i+intial][k]!='1') f=1;
            }
            if(f==0) intial++;
            else break;
            
        }
        return intial;
    }
}