import java.util.Hashtable;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int counter=0,n=nums.length;
        Hashtable<Integer, Integer> prefixSum=new Hashtable<>();
        prefixSum.put(0,1);
        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(prefixSum.containsKey(sum-k)){
                counter=counter+prefixSum.get(sum-k);
            }
            if(prefixSum.containsKey(sum)){
                prefixSum.put(sum,prefixSum.get(sum)+1);
            }else{
                prefixSum.put(sum,1);
            }  
        }
        return counter;
        
    }
}