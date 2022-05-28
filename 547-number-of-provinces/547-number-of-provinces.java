class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        visited=new boolean[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                c++;
                visit(i,isConnected);
                visited[i]=true;
            }
        }
        return c;
    }
    private void visit(int i,int[][] isConnected){
        if(!visited[i]){
            visited[i]=true;
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1) visit(j,isConnected);
            }
        }
    }
}