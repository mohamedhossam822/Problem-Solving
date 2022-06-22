class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++) if(nums[i]>0) set.add(nums[i]);
        int number=1;
        while(set.contains(number)) number++;
        return number;
    }
}