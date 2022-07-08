class Solution {
    int[][][] grid;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        grid=new int[m+1][n+1][target+1];
        return backTrack(0,0,m,0,target,houses,cost,n);
    }
    
    public int backTrack(int index,int preColor,int m,
                         int neigbh,int target,int[] houses, int[][] cost, int n){
        
        if(m==index){
            if(target==neigbh) return 0;
            return -1;
        }
        if(neigbh>target) return -1;
        if(grid[index][preColor][neigbh]!=0) return grid[index][preColor][neigbh];
        
        int min=Integer.MAX_VALUE;
        if(houses[index]!=0){
            if(preColor!=houses[index]) neigbh++;
            preColor=houses[index];
            return backTrack(index+1,preColor,m,neigbh,target,houses,cost,n);
        }
        
        for(int i=1;i<=n;i++){
            int sum=cost[index][i-1];
            if(preColor!=i) neigbh++;
            int val2=backTrack(index+1,i,m,neigbh,target,houses,cost,n);
            if(val2!=-1){
                sum+=val2;
                if(sum<min) min=sum;
            }
            if(preColor!=i) neigbh--;
            sum=0;
            
        }
        if(min==Integer.MAX_VALUE) min=-1;
        grid[index][preColor][neigbh]=min;
        return min;
    }
}