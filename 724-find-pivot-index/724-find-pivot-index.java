class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int[] sumRight=new int[n];
        sumRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)  sumRight[i]=nums[i]+sumRight[i+1];
        if(sumRight[1]==0) return 0;
        for(int i=1;i<n-1;i++){
            nums[i]+=nums[i-1];
            if(sumRight[i+1]==nums[i-1]) return i;
        }
        nums[n-1]+=nums[n-2];
        
        if(nums[n-2]==0) return n-1;
        return -1;
    }
}