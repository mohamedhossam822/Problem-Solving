class Solution {
    int[] dp;
    public int numSquares(int n) {
        int nums = (int) Math.floor(Math.sqrt(n));
        dp=new int[n+1];
        return findMin(n,nums);
    }
    
    private int findMin(int n,int nums){
        if(n==0) return 0;
        if(n<0) return Integer.MAX_VALUE;
        if(dp[n]!=0) return dp[n];
        int min=Integer.MAX_VALUE;
        int val=min;
        for(int i=1;i<=nums;i++){
            val=findMin(n-i*i,nums);
            if(val<min) min=val+1;
        }
        dp[n]=min;
        return min;
    }
}