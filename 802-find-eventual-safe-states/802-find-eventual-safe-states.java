class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> res=new ArrayList<>();
        boolean[] safe=new boolean[graph.length];
        boolean[] visited=new boolean[graph.length];
        for(int i=0;i<n;i++){
            if(graph[i].length==0){
                safe[i]=true;
                visited[i]=true;
            } 
        }
        for(int i=0;i<n;i++){
            if(!visited[i])
            dfs(i,graph,visited,safe);
        }
        
        for(int i=0;i<n;i++)
            if(safe[i])
                res.add(i);
        
        return res;
    }
    
    public boolean dfs(int index,int[][] graph,boolean[] visited,boolean[] safe){
        if(safe[index]) return true;
        if(visited[index]) return false;
        visited[index]=true;
        boolean res=true;;
        for(int i=0;i<graph[index].length;i++)
            res&=dfs(graph[index][i],graph,visited,safe);
        safe[index]=res;
        return res;
        
    }
}