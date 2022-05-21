class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        int temp;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            if(i-1>dp[i-1]) dp[i-1]=i-1;
            int max=0;
            for(int j=1;j<=i/2;j++){
                temp=j*dp[i-j];
                if(temp>max) max=temp;
            }
            dp[i]=max;
        }
        return  dp[n];
    }
}