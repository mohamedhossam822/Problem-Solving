class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>());
        Backtrack(0,nums,nums.length,new ArrayList<Integer>());
        return res;
    }
    //backtrack function to get all possible outcomes
    public  void Backtrack(int start,int[] nums,int n,List<Integer> points){
        if(start==n) return;
        for(int i=start;i<n;i++){
            points.add(nums[i]);
            res.add(new ArrayList<>(points));
            Backtrack(i+1,nums,n,points);
            points.remove(points.size()-1); 
        } 
    }  
}