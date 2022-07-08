class Solution {
    int[][][] grid;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        grid=new int[m+1][n+1][target+1];
        return backTrack(0,0,m,target,houses,cost,n);
    }
    
    public int backTrack(int index,int preColor,int m,int target,int[] houses, int[][] cost, int n){
        
        if(m==index){
            if(target==0) return 0;
            return -1;
        }
        if(target<0) return -1;
        
        if(grid[index][preColor][target]!=0) return grid[index][preColor][target];
        
        
        grid[index][preColor][target]=Integer.MAX_VALUE;
        int oldtarget=target;
        if(houses[index]!=0){
            if(preColor!=houses[index]) target--;
            grid[index][preColor][oldtarget]=backTrack(index+1,houses[index],m,target,houses,cost,n);
            return grid[index][preColor][oldtarget];
        }
        
        for(int i=1;i<=n;i++){
            int sum=cost[index][i-1];
            if(preColor!=i) target--;
            int val2=backTrack(index+1,i,m,target,houses,cost,n);
            if(val2!=-1){
                sum+=val2;
                if(sum<grid[index][preColor][oldtarget]) grid[index][preColor][oldtarget]=sum;
            }
            if(preColor!=i) target++;
            sum=0;
            
        }
        if(grid[index][preColor][oldtarget]==Integer.MAX_VALUE) grid[index][preColor][oldtarget]=-1;
        return grid[index][preColor][oldtarget];
    }
}