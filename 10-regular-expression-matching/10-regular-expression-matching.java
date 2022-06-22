class Solution {
    int sLen,pLen;
    char[][] grid;
    public boolean isMatch(String s, String p) {
        sLen=s.length();
        pLen=p.length();
        grid=new char[sLen][pLen];
        return isMatch(s,0,p,0);
    }
    
    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if(sIndex>=sLen && pIndex>=pLen) return true;
        if(pLen<=pIndex) return false;
        //pattern is x*
        if(pIndex<pLen-1 && p.charAt(pIndex+1)=='*'){
            
            for(int i=sIndex;i<=sLen;i++){
                
                if(isMatch(s,i,p,pIndex+2)){
                    if(sIndex<sLen) grid[sIndex][pIndex]='T';
                    return true; 
                }
                
                if(i<sLen && s.charAt(i)!=p.charAt(pIndex) && p.charAt(pIndex)!='.'){
                    grid[sIndex][pIndex]='F';
                    return false; 
                }
            }
            
        }
        //pattern is '.' or x
        if(sIndex>=sLen) return false;
        
        if(p.charAt(pIndex)=='.' || p.charAt(pIndex)==s.charAt(sIndex)){
            if(isMatch(s,sIndex+1,p,pIndex+1)){
                grid[sIndex][pIndex]='T';
                return true; 
            }
        }
        
        //All cases failed
        grid[sIndex][pIndex]='F';
        return false; 
    }
}