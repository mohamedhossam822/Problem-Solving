class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        //0 not visited
        //1 green
        //2 blue
        for(int i=0;i<n;i++){
            if(color[i]==0 && !dfs(0,i,graph,color)) return false;
        }
        
        return true;
    }
    public boolean dfs(int preColor,int index,int[][] graph,int[] color){
        if(color[index]!=0){
            if(preColor==color[index]) return false;
            return true;
        }
        int newColor= preColor==1 ? 2 : 1;
        color[index]=newColor;
        for(int i=0;i<graph[index].length;i++){
            if(!dfs(newColor,graph[index][i],graph,color)) return false;
        }
        return true;
    }
}