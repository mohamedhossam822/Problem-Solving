class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp=new int[amount+1];
        for(int i=0;i<coins.length;i++) if(coins[i]<=amount) dp[coins[i]]=1;
        for(int i=1;i<=amount;i++){
            if(dp[i]==1) continue;
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++)
            {
                int moneyNeeded=i-coins[j];
                if(moneyNeeded<=0) continue; 
                if(dp[moneyNeeded]!=0 && dp[moneyNeeded]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[moneyNeeded]+1);
                }
            }
        }
        if(dp[amount]==0 || dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}