class Solution {
    public int minMoves2(int[] nums) {
        int avg=0;
        int count=0;
        int n=nums.length;
        Arrays.sort(nums);
        if(n%2==1) avg=nums[n/2];
        else avg=(nums[(n/2)-1]+nums[n/2])/2;
        
        for(int num : nums) count+=Math.abs(num-avg);
        
        return count;
    }
}