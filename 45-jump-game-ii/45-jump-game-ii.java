class Solution {
    public int jump(int[] nums) {
        int n=nums.length,maxJumps;
        int jumps=0;
        for(int i=0;i<n-1;i++){
            jumps++;
            maxJumps=nums[i]+i;
            if(maxJumps>=n-1) return jumps;
            for(int j=1;j<=nums[i];j++){
                if(nums[i+j]+i+j>nums[maxJumps]+maxJumps) maxJumps=i+j;
            }
            i=maxJumps-1;
            
        }
        return jumps;
            
        
    }
}