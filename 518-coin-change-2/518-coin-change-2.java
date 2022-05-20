
class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int[] prev=new int[amount+1],cur=new int[amount+1];
        for (int i = 0; i <=amount ; i++) {
            prev[i]=i%coins[0]==0?1:0;
        }
        for (int i = 1; i <coins.length ; i++) {
            for (int j = 0; j <=amount ; j++) {
                int not_take=prev[j];
                int take=0;
                if (coins[i]<=j) take=cur[j-coins[i]];
                cur[j]=take+not_take;
            }
            prev=cur;
        }
        return prev[amount];
    }
}