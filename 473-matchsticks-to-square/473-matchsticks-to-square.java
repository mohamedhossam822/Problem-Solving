import java.util.Map;
class Solution {
    int maxSide;
    public boolean makesquare(int[] matchsticks) {
        
        int n=matchsticks.length;
        int premiter=0;
        for(int side:matchsticks) premiter+=side;
        int[] sets=new int[4];
        maxSide=premiter/4;
        if(maxSide*4!=premiter) return false;
        Arrays.sort(matchsticks);
        return backTrack(n-1,matchsticks,sets,n);
    }
    
    private boolean backTrack(int index,int[] matchsticks,int[] sets,int n){
        if(index==-1){
            int val=sets[0];
            for(int i=1;i<4;i++){
                if(val!=sets[i]) return false;
            }
            return true;
        }
        for(int i=0;i<4;i++){
            if(sets[i]+matchsticks[index]>maxSide) continue;
            sets[i]+=matchsticks[index];
            if(backTrack(index-1,matchsticks,sets,n)) return true;
            sets[i]-=matchsticks[index];
        }
        return false;
    }
}