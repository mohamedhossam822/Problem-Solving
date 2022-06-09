class Solution {
    
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adjList=new ArrayList<>(n);
        for(int i=0;i<n;i++)adjList.add(null);
        
        for(int i=0;i<connections.length;i++){
            if(adjList.get(connections[i][0])==null) adjList.set(connections[i][0],new ArrayList<>());
            adjList.get(connections[i][0]).add(connections[i][1]);
            if(adjList.get(connections[i][1])==null) adjList.set(connections[i][1],new ArrayList<>());
            adjList.get(connections[i][1]).add(connections[i][0]);
        }
        
        int numberOfSystems=-1;
        boolean[] visited=new boolean[n];
        for(int i=0;i<adjList.size();i++){
            if(!visited[i]){
                dfs(i,adjList,visited);
                numberOfSystems++;
            }
        }
        if(connections.length<n-1) return -1;
        return numberOfSystems;
    }
    
    public void dfs(int i,List<List<Integer>> adjList,boolean[] visited){
        if(visited[i]) return;
        visited[i]=true;
        if(adjList.get(i)==null) return;
        for(int j=0;j<adjList.get(i).size();j++){
            dfs(adjList.get(i).get(j),adjList,visited);
        }
    }
}