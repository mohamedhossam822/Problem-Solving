class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i=Integer.MAX_VALUE,j=Integer.MAX_VALUE,k=Integer.MAX_VALUE;
        for(int a=0;a<nums.length;a++){
            if(nums[a]<=i && nums[a]<=j && nums[a]<=k) i=nums[a];
            else if(nums[a]<=j && nums[a]<=k) j=nums[a];
            else return true;
        }
        return false;
    }
}