class Solution {
    public int minMoves2(int[] nums) {
        int count=0;
        int avg=quickSelect(0,nums.length-1,nums);
        
        for(int num : nums) count+=Math.abs(num-avg);
        
        return count;
    }
    private int quickSelect(int start,int end,int[] nums){
        int pivot=nums[end];
        int position=start;
        
        for(int i=start;i<=end;i++){
            if(nums[i]<pivot){
                swap(position,i,nums);
                position++;
            }
        }
        
        if(position==nums.length/2) return pivot; 
        
        swap(position,end,nums);
        
        if(position<(nums.length/2)) return quickSelect(position+1,end,nums); 
        
        return quickSelect(start,position-1,nums); 
    }
    
    private void swap(int i, int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}