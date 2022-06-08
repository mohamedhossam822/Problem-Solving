class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        int maxDistance=mat.length+mat[0].length;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0){
                     int left=j>0 ?  mat[i][j-1]+1 : maxDistance;
                     int up=i>0 ?    mat[i-1][j]+1 : maxDistance;
                     mat[i][j]=Math.min(left,up);
                }
            }
        }
        
        for(int i=mat.length-1;i>=0;i--){
            for(int j=mat[0].length-1;j>=0;j--){
                if(mat[i][j]!=0){
                     int right=j<mat[0].length-1 ? mat[i][j+1]+1 : maxDistance;
                     int down=i<mat.length-1 ? mat[i+1][j]+1 : maxDistance;
                     mat[i][j]=Math.min(Math.min(right,down),mat[i][j]);
                }
            }
        }
        
        return mat;
    }  
}