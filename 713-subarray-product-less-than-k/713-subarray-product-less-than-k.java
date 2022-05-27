class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product=1;
        int i,index=0;
        int c=0;
        for(i=0;i<nums.length;i++){
            product*=nums[i];
            while(index<=i && product>=k){
                product=product/nums[index];
                c+=(i-index);
                index++;
            }
            
        }
        while(index<nums.length){
            product=product/nums[index];
            c+=(i-index);
            index++;
            
        }
        
        return c;
    }
}