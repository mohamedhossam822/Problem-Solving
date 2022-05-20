class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0,0);
        int temp;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i==coins[j]) dp.put(i,1);
                else if(i>coins[j]){
                    if(dp.containsKey(i-coins[j])){
                        temp=1+dp.get(i-coins[j]);
                        if(dp.containsKey(i)){
                            if(temp<dp.get(i)) dp.put(i,temp);
                        }else dp.put(i,temp);
                    }
                }
            }
        }
        if(dp.containsKey(amount)) return dp.get(amount);
        return -1;
    }
}