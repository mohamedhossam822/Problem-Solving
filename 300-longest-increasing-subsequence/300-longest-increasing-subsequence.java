class Solution {
    int[] grid;
    int n;
    int globalSum=0;
    public int lengthOfLIS(int[] nums) {
        n=nums.length;
        grid=new int[n];
        if(n==1) return 1;
        int val=getMax(0,nums);
        getMax(0,nums);
        return globalSum;
    }
    private int getMax(int i,int[] nums){
        if(grid[i]!=0) return grid[i];
        int otherSum=0;
        int sum=0;
        int maxSum=1;
        for(int r=i+1;r<n;r++){
            sum=getMax(r,nums);
            if(nums[i]<nums[r]){
                if(sum+1>maxSum) maxSum=sum+1;
                if(sum+1>globalSum) globalSum=sum+1;
                
            } 
            else{
                if(sum>globalSum) globalSum=sum;
            }
        }
        grid[i]=maxSum;
        return maxSum;
    }
}