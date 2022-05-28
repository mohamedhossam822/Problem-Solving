class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        boolean[]  exist=new boolean[n+1];
        for(int i=0;i<n;i++){
            exist[nums[i]]=true;
        }
        for(int i=0;i<n+1;i++){
            if(!exist[i]) return i;
        }
        return -1;
        
    }
}