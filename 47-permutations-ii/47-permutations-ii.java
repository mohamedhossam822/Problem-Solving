class Solution {
    HashSet<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<Integer> entered = new HashSet<>();
        backtrack(nums, new ArrayList<>(), new HashSet<>());
        return new ArrayList<>(res);
    }

    public void backtrack(int[] nums, List<Integer> points, HashSet<Integer> entered) {
        if (points.size() == nums.length) 
            res.add(new ArrayList<>(points));
        else{
            for (int i = 0; i < nums.length; i++){
                if(entered.contains(i)) continue;
                points.add(nums[i]);
                entered.add(i);
                backtrack(nums, points, entered);
                entered.remove(i);
                points.remove(points.size() - 1);
            }
        }
    }
}
