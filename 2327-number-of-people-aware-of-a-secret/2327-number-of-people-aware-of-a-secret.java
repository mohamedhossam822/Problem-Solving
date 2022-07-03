class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp=new long[n];
        for(int i=n-1;i>=0;i--)
        {
            if((i+forget)>=n) dp[i]=1;
            
            int end=Math.min(i+forget,n);
            for(int j=delay+i;j<end;j++){
                dp[i]+=dp[j];
                dp[i]%=1000000007;
            }
        }
        
        return (int)dp[0];
    }
}