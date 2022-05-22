class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid=0,resL=-1,resR=-1,l=0,r=nums.length-1;
        while(r>=l){
            mid=l+(r-l)/2;
            if(nums[mid]==target){
                resL=mid;
                resR=mid;
                while(resL>0 && nums[resL-1]==target) resL--;
                while(resR<nums.length-1 && nums[resR+1]==target) resR++;
                break;
            }
            else if(nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return new int[]{resL,resR};
    }
}