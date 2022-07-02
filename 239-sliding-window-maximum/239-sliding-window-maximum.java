
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> tree =new TreeMap<Integer, Integer>();
        int n=nums.length;
        int size=0;
        int index=0;
        int[] res=new int[n-k+1];
        for(int i=0;i<n;i++){ 
            
            if(tree.containsKey(nums[i])) tree.put(nums[i],tree.get(nums[i])+1);
            else tree.put(nums[i],1);
            
            size++;
            
            if(size==k){
                
                res[index]=tree.lastKey();
                index++;
                
                int key=nums[i-k+1];
                if(tree.get(key)>1) tree.put(key,tree.get(key)-1);
                else    tree.remove(key);
                
                size--;
            }
            
        }
        
        return res;
    }
}