import java.util.HashMap;
class Solution {
    HashMap<Integer, Integer> dp;
    public int coinChange(int[] coins, int amount) {
        dp = new HashMap<>();
        int val=getMin(coins,amount);
        if(val==Integer.MAX_VALUE) return -1;
        return val;
    }
    private int getMin(int[] coins, int amount){
        if (amount==0) return 0;
        if (amount<0) return Integer.MAX_VALUE;
        if(dp.containsKey(amount)) return dp.get(amount);
        int min=Integer.MAX_VALUE;
        int val=min;
        for(int i=0;i<coins.length;i++){
            val=getMin(coins,amount-coins[i]);
            if(val<min) min=val+1;
        }
        dp.put(amount,min);
        return min;
    }
}