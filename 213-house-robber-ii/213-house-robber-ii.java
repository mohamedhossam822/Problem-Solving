class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(getMaxMoney(0,nums.length-2,nums),getMaxMoney(1,nums.length-1,nums));
    }
    
    public int getMaxMoney(int start,int end,int[] nums){
        if(start==end) return nums[start];
        int max=0,temp;
        int second=nums[end];
        int first=Math.max(nums[end-1],second);
        for(int i=end-2;i>=start;i--){
            temp = first;
            first=Math.max(first,nums[i]+second);
            second=temp;
        }
        return first;
    }
}