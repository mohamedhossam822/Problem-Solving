class Solution {
    public int firstMissingPositive(int[] nums) {
        int res=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==i+1) continue;
            if(nums[i]>0 && nums[i]<n) {
                int temp=nums[nums[i]-1];
                if(temp!=nums[i]){
                   nums[nums[i]-1]=nums[i];
                    nums[i]=temp;
                    i--; 
                } 
            }
        }
        for(int i=0;i<n;i++){
            if((i+1)!=nums[i]) return i+1;
        }
        return n+1;
    }
}