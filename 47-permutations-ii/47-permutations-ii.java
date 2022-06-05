class Solution {
    List<List<Integer>> res = new LinkedList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<Integer> entered = new HashSet<>();
        backtrack(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }

    public void backtrack(int[] nums, List<Integer> points, HashSet<Integer> entered) {
        if (points.size() == nums.length) 
            res.add(new ArrayList<>(points));
        else{
            HashSet<Integer> computed=new HashSet<>();
            for (int i = 0; i < nums.length; i++){
                if(entered.contains(i) || computed.contains(nums[i])) continue;
                computed.add(nums[i]);
                points.add(nums[i]);
                entered.add(i);
                backtrack(nums, points, entered);
                entered.remove(i);
                points.remove(points.size() - 1);
            }
        }
    }
}
