class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0,candidates,target,0,new ArrayList<>());
        return res;
    }
    public void backtrack(int start,int[] candidates,int target,int sum,List<Integer> points){
        if(sum==target) {
            res.add(new ArrayList<>(points));
            return;
        }
        if(sum>target) return;
        //To not explore already visited numbers
        HashSet<Integer> explored=new HashSet<>();
        //Loop through the array to get the next element
        for(int i=start;i<candidates.length;i++){
            if(explored.contains(candidates[i])) continue;
            explored.add(candidates[i]);
            //Add the point to the list and add the sum
            sum+=candidates[i];
            points.add(candidates[i]);
            //Explore this option
            backtrack(i+1,candidates,target,sum,points);
            //Back track after exploring
            sum-=candidates[i];
            points.remove(points.size()-1);
        }
    }
}
