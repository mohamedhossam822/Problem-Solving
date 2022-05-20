class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp=new int[amount+1];
        int temp;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i==coins[j]) dp[i]=1;
                else if(i>coins[j]){
                    temp=i-coins[j];
                    if(dp[temp]!=0 &&(dp[i]==0 || 1+dp[temp]<dp[i])) dp[i]=1+dp[temp];
                }
            }
        }
        if(dp[amount]!=0) return dp[amount];
        return -1;
    }
}