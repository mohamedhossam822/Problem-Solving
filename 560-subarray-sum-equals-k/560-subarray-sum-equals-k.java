class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> sums=new HashMap<>();
        int sum=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k) res++;
            int difference=sum-k;
            if(sums.containsKey(difference)) res+=sums.get(difference);
            if(sums.containsKey(sum)) sums.put(sum,sums.get(sum)+1);
            else sums.put(sum,1);
        }
        return res;
    }
}