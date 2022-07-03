class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
         int prediff = nums[1] - nums[0];
        int count = prediff != 0 ? 2 : 1;
        for(int i=2;i<nums.length;i++){
            
            
            int diff=nums[i]-nums[i-1];
            if((diff>0 && prediff<=0) || (diff<0 && prediff>=0)){
                count++;
                prediff=diff;
            }
            
        }
        return count;
    }
}