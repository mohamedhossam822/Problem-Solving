class Solution {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<Integer>(0));
        Backtrack(0,nums,nums.length,new LinkedList<Integer>());
        return res;
    }
    //backtrack function to get all possible outcomes
    public  void Backtrack(int start,int[] nums,int n,LinkedList<Integer> points){
        if(start==n) return;
        for(int i=start;i<n;i++){
            points.add(nums[i]);
            res.add(new LinkedList<>(points));
            Backtrack(i+1,nums,n,points);
            points.remove(points.size()-1); 
        } 
    }  
}