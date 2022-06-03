class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target=graph.length-1;
        res=new ArrayList<>();
        dfs(0,graph,target,new ArrayList<Integer>());
        return res;
    }
    public void dfs(int i,int[][] graph,int target,List<Integer> list){
        list.add(i);
        if(i==target){
            res.add(list);
            return;
        }
        for(int path : graph[i]) dfs(path,graph,target,new ArrayList<>(list));
    }
}