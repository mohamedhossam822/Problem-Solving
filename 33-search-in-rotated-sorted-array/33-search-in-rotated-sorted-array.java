class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1,mid;
        while(r>=l){
            mid=l+(r-l)/2;
            if(nums[mid]== target) return mid;
            else if(nums[0]<=target){
                if(nums[mid]>target) r=mid-1;
                else{
                    if(nums[mid]>=nums[0]) l=mid+1;
                    else r=mid-1;
                } 
            }
            else{
                if(nums[mid]<target) l=mid+1;
                else{
                    if(nums[mid]>=nums[0]) l=mid+1;
                    else r=mid-1;
                } 
            }
        }
        return -1;
    }
}