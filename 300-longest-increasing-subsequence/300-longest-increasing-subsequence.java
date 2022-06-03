class Solution {
    public int lengthOfLIS(int[] nums) {
        //list of lists of integers
        int[] dp=new int[nums.length];
        int val,max=1;
        //loop through the array determining the longest subsequence from this point
        for(int i=nums.length-1;i>=0;i--){
            dp[i]=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    val=1+dp[j];
                    if(val>dp[i]) dp[i]=val;
                    if(dp[i]>max) max=dp[i];
                }
            }
        }
        return max;
    }
}