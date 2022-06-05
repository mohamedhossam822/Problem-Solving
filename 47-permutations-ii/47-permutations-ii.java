import java.util.Map.Entry;
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> numsFreq=new HashMap<>();
        for(int i=0;i<nums.length;i++)
            numsFreq.put(nums[i],numsFreq.getOrDefault(nums[i],0)+1);
        backtrack(nums, new ArrayList<>(), numsFreq);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> points, HashMap<Integer,Integer> numsFreq) {
        if (points.size() == nums.length) 
            res.add(new ArrayList<>(points));
        else{
            for(Entry<Integer, Integer> entry: numsFreq.entrySet()) {
                if(entry.getValue()>0){
                    points.add(entry.getKey());
                    numsFreq.put(entry.getKey(),numsFreq.get(entry.getKey())-1);
                    backtrack(nums, points, numsFreq);
                    points.remove(points.size()-1);
                    numsFreq.put(entry.getKey(),numsFreq.get(entry.getKey())+1);
                }
            }
        }
    }
}
