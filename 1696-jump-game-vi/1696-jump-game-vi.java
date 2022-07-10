class Solution {
    public int maxResult(int[] nums, int k) {
        int n=nums.length;
        TreeMap<Integer, Integer> largetElements= new TreeMap<Integer, Integer>();
        Integer[] dp=new Integer[nums.length];
        dp[n-1]=nums[n-1];
        int size=1;
        largetElements.put(dp[n-1],1);
        for(int i=n-2;i>=0;i--){
            //Remove the last element
            if(size>k){
                int freq=largetElements.get(dp[k+i+1]);
                if(freq>1) largetElements.put(dp[k+i+1],freq-1);
                else largetElements.remove(dp[k+i+1]);
                size--;
            }
            dp[i]=nums[i]+largetElements.lastKey();
            //Add the new element
            size++;
            int freq=1;
            if(largetElements.containsKey(dp[i])) freq+=largetElements.get(dp[i]);
            largetElements.put(dp[i],freq);
        }
        return dp[0];
        
    }
}