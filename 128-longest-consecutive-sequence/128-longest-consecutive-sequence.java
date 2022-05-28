class Solution {
    public int longestConsecutive(int[] nums) {
        int n,count,maxL=0;
        HashSet<Integer> Set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(!Set.contains(nums[i]-1)){
                count=1;
                n=nums[i];
                while(Set.contains(++n)) count++;
                if(count>maxL) maxL=count;
            }
        }
        return maxL;
    }
}