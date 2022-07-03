class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] cache=new long[n];
        boolean[] visited=new boolean[n];
        
        return (int)visit(0,n, delay, forget,cache,visited);
    }
    private long visit(int index,int n, int delay, int forget,long[] cache,boolean[] visited){
        if(visited[index]) return cache[index];
        if((index+forget)>=n) cache[index]=1;
        
        for(int i=delay+index;i<index+forget;i++){
            if(i>=n) break;
            cache[index]+=visit(i,n,delay,forget,cache,visited);
            cache[index]%=1000000007;
        }
        visited[index]=true;
        return cache[index];
        
    }
}