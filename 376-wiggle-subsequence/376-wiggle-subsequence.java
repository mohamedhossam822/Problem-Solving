class Solution {
    int[][] grid;
    int n;
    int globalSum;
    public int wiggleMaxLength(int[] nums) {
        n=nums.length;
        grid=new int[2][n];
        globalSum=1;
        getMax(0,nums,true);
        getMax(0,nums,false);
        return globalSum;
    }
    private int getMax(int i,int[] nums,boolean t){
        int sum=0;
        int maxSum=1;
        if(t){
            if(grid[0][i]!=0) return grid[0][i];
            for(int r=i+1;r<n;r++){
                sum=getMax(r,nums,!t);
                if(nums[i]>nums[r]){
                    if(sum+1>maxSum){
                        maxSum=sum+1;
                        if(maxSum>globalSum) globalSum=maxSum;
                    }
                }else{
                    getMax(r,nums,t);
                }
            }
            grid[0][i]=maxSum;
            return maxSum;
        }
        else{
            if(grid[1][i]!=0) return grid[1][i];
            for(int r=i+1;r<n;r++){
                sum=getMax(r,nums,!t);
                if(nums[i]<nums[r]){
                    if(sum+1>maxSum){
                        maxSum=sum+1;
                        if(maxSum>globalSum) globalSum=maxSum;
                    }
                }else{
                    getMax(r,nums,t);
                }
            }
            grid[1][i]=maxSum;
            return maxSum;
            
        }
    }
}