class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int profit=0;
        int buyDay=0;
        for(int i=1;i<prices.length;i++){
            if(prices[buyDay]>=prices[i]) buyDay=i;
            else {
                profit=prices[i]-prices[buyDay];
                maxProfit= profit>maxProfit ? profit:maxProfit;
            }
        }
        return maxProfit;
    }
}