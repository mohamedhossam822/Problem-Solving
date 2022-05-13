class Solution {
    public int maxProfit(int[] prices, int fee) {
        int Buy=-prices[0];
        int Sell=0;
        int Sold=0;
        
        for(int i=1;i<prices.length;i++){
            Sell=Math.max(Buy+prices[i]-fee,Sell);
            Buy=Math.max(Sold-prices[i],Buy);
            Sold=Sell;
        }
        return Sold;
    }
}