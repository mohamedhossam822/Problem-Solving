class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int target=0;
        for(int number :nums) target+=number;
        target-=x;
        if(target==0) return nums.length;
        int l=0,r=0;
        int sum=nums[0];
        int max=-1;
        while(true){
            if(sum==target){
                if((r-l+1)>max) max=r-l+1;
                sum-=nums[l];
                l++;
            } 
            if(sum<target){
                r++;
                if(r>=n) break;
                sum+=nums[r];
            }else{
                sum-=nums[l];
                l++;
                
                if(l>=r) {
                    if(l>=n) break;
                    sum=nums[l];
                    r=l;
                }
            }
        }
        if(max==-1) return -1;
        return nums.length-max;
        
    }
    
}