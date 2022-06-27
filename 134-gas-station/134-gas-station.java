class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank=0;
        int n=gas.length;
        int res;
        for(int i=0;i<n;i++){
            if(gas[i]>=cost[i]){
                res=travel(n,gas[i]-cost[i],i,i+1,gas,cost);
                if(res==i) return i;
                else if(res<i) return -1;
                else i=res;
            }
        }
        
        return -1;
    }
    
    private int travel(int n,int tank,int start,int next,int[] gas, int[] cost){
        if(next==n) next=0;
        if(start==next) return start;
        tank+=gas[next];
        if(tank<cost[next]) return next;
        tank-=cost[next];
        return travel(n,tank,start,next+1,gas,cost);
    }
}