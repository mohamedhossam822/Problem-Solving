class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,0,new ArrayList<>());
        return res;
    }
    public void findCombinations(int start,int[] candidates,int target,int sum,List<Integer> points){
        
        if(sum==target) {
            res.add(new ArrayList<>(points));
            return;
        }
        
        if(sum>target) return;
        
        //To not explore already visited numbers
        int prev=-1;
        
        //Loop through the array to get the next element
        for(int i=start;i<candidates.length;i++){
            if(prev>=0 && candidates[i]==candidates[prev]) continue;
            prev=i;
            sum+=candidates[i];
            points.add(candidates[i]);
            findCombinations(i+1,candidates,target,sum,points);
            sum-=candidates[i];
            points.remove(points.size()-1);
        }
    }
}
