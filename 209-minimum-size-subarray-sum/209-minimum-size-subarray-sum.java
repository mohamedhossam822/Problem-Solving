class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int sum=0;
        int c=0;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target) return 1;
            sum+=nums[i];
            c++;
            while(sum>=target){
                if(sum>=target && c<min) min=c;
                sum-=nums[index];
                c--;
                index++;
            }
        }
        if(index==0 && sum<target) return 0;
        return min;
    }
}