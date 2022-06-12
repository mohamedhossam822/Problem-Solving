class Solution {
    boolean res;
    public boolean canReach(int[] arr, int start) {
        res=false;
        int n=arr.length;
        boolean[] visited=new boolean[n];
        dfs(arr,start,visited,n);
        return res;
    }
    public void dfs(int[] arr,int i,boolean[] visited,int n){
        if(res) return;
        if(i>=n || i<0) return;
        if(visited[i]) return;
        visited[i]=true;
        if(arr[i]==0){
            res=true;
            return;
        }
        dfs(arr,i+arr[i],visited,n);
        dfs(arr,i-arr[i],visited,n);
    }
}