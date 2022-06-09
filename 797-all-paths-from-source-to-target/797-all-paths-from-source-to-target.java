class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target=graph.length-1;
        res=new ArrayList<>();
        List<Integer> list=new ArrayList<Integer>();
        list.add(0);
        dfs(0,graph,target,list);
        return res;
    }
    public void dfs(int i,int[][] graph,int target,List<Integer> list){
        for(int path : graph[i]){
            list.add(path);
            if(target==path) res.add(new ArrayList<>(list));
            else dfs(path,graph,target,list);
            list.remove(list.size()-1);
        } 
    }
}