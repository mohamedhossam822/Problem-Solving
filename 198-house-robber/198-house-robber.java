class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        int first=nums[n-1];
        int second=Math.max(nums[n-2],first);
        int temp;
        
        for(int i=n-3;i>=0;i--){
            temp=second;
            second=Math.max(second,first+nums[i]);
            first=temp;
        }
        return second;
    }
}