class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int second=cost[n-1];
        int first=cost[n-2];
        
        for(int i=n-3;i>=0;i--){
            int temp=first;
            first=cost[i]+Math.min(first,second);
            second=temp;
        }
        
        return Math.min(second,first);
    }
}