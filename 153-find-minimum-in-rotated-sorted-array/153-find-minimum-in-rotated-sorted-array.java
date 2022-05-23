class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,mid=0,min=0;
        if(nums[r]>nums[l]) return nums[l];
        while(r>=l){
            mid=l+(r-l)/2;
            if(nums[mid]>=nums[0]) l=mid+1;
            else {
               min=mid;
                break;
            }
        }
        while(min>0 && nums[min-1]<nums[min]) min--;
        return nums[min];
    }
}