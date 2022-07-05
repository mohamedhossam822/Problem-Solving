class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        for(int num: nums) set.add(num);
        for(int num: nums){
            if(set.contains(num-1)) continue;
            int val=1;
            while(set.contains(num+val)) val++;
            if(val>max) max=val;
        }
        
        return max;
    }
}