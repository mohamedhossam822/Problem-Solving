class Solution {
    int[] grid;
    int n;
    int globalSum;
    public int lengthOfLIS(int[] nums) {
        n=nums.length;
        grid=new int[n];
        globalSum=1;
        getMax(0,nums);
        return globalSum;
    }
    private int getMax(int i,int[] nums){
        if(grid[i]!=0) return grid[i];
        int sum=0;
        int maxSum=1;
        for(int r=i+1;r<n;r++){
            sum=getMax(r,nums);
            if(nums[i]<nums[r] && sum+1>maxSum){
                maxSum=sum+1;
            } 
        }
        grid[i]=maxSum;
        if(maxSum>globalSum) globalSum=maxSum;
        return maxSum;
    }
}