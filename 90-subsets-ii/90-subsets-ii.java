class Solution {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(new ArrayList<Integer>());
        Backtrack(0,nums,nums.length,new ArrayList<Integer>());
        HashSet<List<Integer>> resSorted=new HashSet<>();
        for(List<Integer> list : res){
            Collections.sort(list);
            resSorted.add(list);
        }
        return new ArrayList<>(resSorted);
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