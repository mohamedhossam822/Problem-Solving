class Solution {
    HashSet<List<Integer>> res=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        Backtrack(0,nums,nums.length,new ArrayList<Integer>());
        return new ArrayList<>(res);
    }
    //backtrack function to get all possible outcomes
    public  void Backtrack(int i,int[] nums,int n,List<Integer> points){
        if(i==n) return;
        points.add(nums[i]);
        if(!res.contains(points)){
            res.add(new ArrayList<>(points));
            Backtrack(i+1,nums,n,points);
        }
        points.remove(points.size()-1); 
        Backtrack(i+1,nums,n,points);
    } 
}