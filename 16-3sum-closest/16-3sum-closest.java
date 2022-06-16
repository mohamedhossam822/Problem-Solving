class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int bestVal=-1;
        int diff=Integer.MAX_VALUE;
        int number=nums[0];
        for(int i=0;i<n-2;i++){
            if(nums[i]==number && i!=0) continue;
            number=nums[i];
            int l=i+1;
            int r=n-1;
            while(r>l){
                int sum=number+nums[l]+nums[r];
                if(sum==target) return target;
                int newDiff=Math.abs(sum-target);
                if(newDiff<diff){
                    diff=newDiff;
                    bestVal=sum;
                }
                if(target>sum) l++;
                else r--;
            }
        }
        
        return bestVal;
        
    }
}