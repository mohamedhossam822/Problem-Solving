class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int l,r,bestVal=-1;
        int sum,newDiff,diff=Integer.MAX_VALUE;
        int number=nums[0];
        for(int i=0;i<n-2;i++){
            number=nums[i];
            l=i+1;
            r=n-1;
            while(r>l){
                sum=number+nums[l]+nums[r];
                if(sum==target) return target;
                newDiff=Math.abs(sum-target);
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