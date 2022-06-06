class Solution {
    public boolean canJump(int[] nums) {
        int maxJumps=-1;
        for(int i=0;i<nums.length-1;i++){
            maxJumps=Math.max(maxJumps-1,nums[i]);
            if(maxJumps==0) return false;
        }
        return true;
    }
}