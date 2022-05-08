class Solution {
    public int maxProfit(int[] prices) {
        int result=0;
        int min=prices[0];
        int max;
        int i=0;
        while(i<prices.length){
            i++;
            while(i<prices.length && prices[i]<min){
                min=prices[i];
                i++;
            }
            if(i>=prices.length) break;
            max=prices[i];
            i++;
            while(i<prices.length && prices[i]>max){
                max=prices[i];
                i++;
            }
            if(max-min>0) result=result+max-min;
            if(i>=prices.length) break;
            min=prices[i];
            
        }
        return result;
    }
}