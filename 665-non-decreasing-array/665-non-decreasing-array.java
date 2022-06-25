class Solution {
    public boolean checkPossibility(int[] nums) {
        
        for(int i=0;i<nums.length-1;i++){
            
            if(nums[i]>nums[i+1]){
                // 2 choices either decrease the current number or increase the next number
                
                //Decrease the current number
                int temp=nums[i];
                nums[i]=nums[i+1];
                if(checkPossibility(nums,i-1)) return true;
                
                //Increase the next number
                nums[i]=temp;
                nums[i+1]=nums[i];
                return checkPossibility(nums,i);
                
            }
        }
        
        return true;
    }
    
    private boolean checkPossibility(int[] nums,int index) {
        for(int i=0;i<nums.length-1;i++)
            if(nums[i]>nums[i+1]) return false;
        return true;
    }
}