class Solution {
    boolean[] visitedF=new boolean[10001];
    boolean[] visitedB=new boolean[10001];
    int[] visitedFI=new int[10001];
    int[] visitedBI=new int[10001];
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        for(int i=0;i<forbidden.length;i++) {
            visitedFI[forbidden[i]]=Integer.MAX_VALUE;
            visitedBI[forbidden[i]]=Integer.MAX_VALUE;
            visitedF[forbidden[i]]=true; 
            visitedB[forbidden[i]]=true; 
        }
        
        int res=dfs(false,0,a,b,x);
        if(res==Integer.MAX_VALUE) return -1;
        return  res;
    }
    
    public int dfs(boolean back,int index,int a,int b,int x){
        
        if(index<0 || index>10000) return Integer.MAX_VALUE;
        if(!back && visitedF[index]) return Integer.MAX_VALUE;
        if(back && visitedB[index]) return Integer.MAX_VALUE;
        if(!back && visitedFI[index]>0) return visitedFI[index];
        if(back && visitedBI[index]>0) return visitedBI[index];
        if(index==x) return 0;
        if(!back) visitedF[index]=true;
        else visitedB[index]=true;
        int result=Integer.MAX_VALUE;
        result=dfs(false,index+a,a,b,x);
        if(!back) result=Math.min(result,dfs(true,index-b,a,b,x));
        
        if(back){
            if(result==Integer.MAX_VALUE) visitedBI[index]=Integer.MAX_VALUE;
            else visitedBI[index]=result+1;
            return visitedBI[index];
        }
        else{
            if(result==Integer.MAX_VALUE) visitedFI[index]=Integer.MAX_VALUE;
            else visitedFI[index]=result+1;
            return visitedFI[index];
        }
        
        
    }
}