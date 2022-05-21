import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[k];
        k--;
        ArrayList<Integer>[] arr=new ArrayList[n+1]; 
        for (int i = 0; i < n+1; i++) {
            arr[i]= new ArrayList<Integer>();
        }
        
        Map<Integer, Integer> Freq
            = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if(Freq.containsKey(nums[i]))
                Freq.put(nums[i],Freq.get(nums[i])+1);
            else Freq.put(nums[i],1);
        }
        
        for (Map.Entry<Integer, Integer> set :Freq.entrySet())
            arr[set.getValue()].add(set.getKey());
        
        for(int i=n;i>=0;i--){
            for(int j=0;j<arr[i].size();j++){
                res[k]=arr[i].get(j);
                k--;
                if(k==-1) return res;
            }
        }
        return res;
        
    }
}