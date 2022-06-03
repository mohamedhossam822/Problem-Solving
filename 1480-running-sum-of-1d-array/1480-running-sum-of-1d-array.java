class Solution {
    public int[] runningSum(int[] nums) {
        if(nums.length==0) return nums;
        //For each element add to it the pre nums[index];
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
}