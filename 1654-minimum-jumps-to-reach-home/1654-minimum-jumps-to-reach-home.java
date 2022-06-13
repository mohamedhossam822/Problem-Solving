class Solution {
    boolean[] visitedF=new boolean[10001];
    boolean[] visitedB=new boolean[10001];
    int[] cacheF=new int[10001];
    int[] cacheB=new int[10001];
    
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
        for(int i=0;i<forbidden.length;i++) {
            cacheF[forbidden[i]]=Integer.MAX_VALUE;
            cacheB[forbidden[i]]=Integer.MAX_VALUE;
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
        
        if(!back && cacheF[index]>0) return cacheF[index];
        if(back && cacheB[index]>0) return cacheB[index];
        
        if(index==x) return 0;
        
        if(!back) visitedF[index]=true;
        else visitedB[index]=true;
        
        int result=Integer.MAX_VALUE;
        
        result=dfs(false,index+a,a,b,x);
        
        if(back){
            if(result==Integer.MAX_VALUE) cacheB[index]=Integer.MAX_VALUE;
            else cacheB[index]=result+1;
            return cacheB[index];
        }
        else{
            result=Math.min(result,dfs(true,index-b,a,b,x));
            if(result==Integer.MAX_VALUE) cacheF[index]=Integer.MAX_VALUE;
            else cacheF[index]=result+1;
            return cacheF[index];
        }  
    }
}