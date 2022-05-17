class Solution {
    int n;
    int m;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        n=mat.length;
        m=mat[0].length;
        int[][] res=new int[n][m];
        int intSum=0,sum=0,i,j;
        for(i=0;i<=k;i++){
            for(j=0;j<=k;j++){
                intSum+=Sum(i,j,mat);
            }
        }
        int z=0;
        int Upi=-k;
        int Doi=k+1;
        int Lj=-k;
        int Rj=k+1;
        for(i=0;i<n;i++){
            sum=intSum;
            Lj=-k;
            Rj=k+1;
            for(j=0;j<m;j++){
                res[i][j]=sum;
                for(z=i-k;z<=k+i;z++){
                    sum-=Sum(z,Lj,mat);
                    sum+=Sum(z,Rj,mat);
                }
                Lj++;
                Rj++;
            }
            for(z=0;z<=k;z++){
                intSum-=Sum(Upi,z,mat);
                intSum+=Sum(Doi,z,mat);
                
            }
            Upi++;
            Doi++;  
        }
        return res;
        
    }
     public int Sum(int i,int j,int[][] mat){
         if(i<0 || j<0) return 0;
         if(i>=n || j>=m) return 0;
         return mat[i][j];
     }
}