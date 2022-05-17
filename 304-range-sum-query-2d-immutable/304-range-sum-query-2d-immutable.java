class NumMatrix {
    int[][] mat;
    int n;
    int m;
    public NumMatrix(int[][] matrix) {
        mat=matrix;
        n=matrix.length;
        m=matrix[0].length;
        int sum=0;
        for(int j=m-1;j>=0;j--){
            sum+=matrix[n-1][j];
            matrix[n-1][j]=sum;
        }
        for(int i=n-2;i>=0;i--){
            sum=0;
            for(int j=m-1;j>=0;j--){
                sum+=matrix[i][j];
                matrix[i][j]=sum+matrix[i+1][j];
            }
        }  
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=mat[row1][col1];
        if(row2+1<n) res-=mat[row2+1][col1];
        if(col2+1<m )res-=mat[row1][col2+1];
        if(row2+1<n && col2+1<m) res+=mat[row2+1][col2+1];
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */