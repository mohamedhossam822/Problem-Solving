class Solution {
    public int maxProfit(int[] prices) {
        int NoStock=0;
        int OldNoStock=0;
        
        int InHand=-prices[0];
        
        int Sold=0;
        int oldSold=0;
        
        for(int i=1;i<prices.length;i++){
            //Sold
            Sold=InHand+prices[i];
            //No stock
            NoStock=Math.max(OldNoStock,oldSold);
            
            //In hand
            InHand=Math.max(InHand,OldNoStock-prices[i]);
            
            
            oldSold=Sold;
            OldNoStock=NoStock;
        }
        return Math.max(Sold,NoStock);
        
    }
}