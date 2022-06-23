class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        boolean nExist=false;
        for(int i=0;i<n;i++){
            if(nums[i]==i) continue;
            if(nums[i]==n) nExist=true;
            if(nums[i]>0 && nums[i]<n) {
                int temp=nums[nums[i]];
                if(temp!=nums[i]){
                    nums[nums[i]]=nums[i];
                    nums[i]=temp;
                    i--; 
                } 
            }
        }
        for(int i=1;i<n;i++){
            if(i!=nums[i]) return i;
        }
        if(nExist) return n+1;
        return n;
    }
}