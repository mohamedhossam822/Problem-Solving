class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> cols=new HashSet<>();
        HashSet<Integer> rows=new HashSet<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        for(int i : cols)
            for(int k=0;k<m;k++) matrix[k][i]=0;
        for(int i : rows)
            for(int k=0;k<n;k++) matrix[i][k]=0;
                
        
    }
}