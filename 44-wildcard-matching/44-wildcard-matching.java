class Solution {
    Boolean[][] grid;
    int m,n;
    public boolean isMatch(String s, String p) {
        m=s.length();
        n=p.length();
        grid=new Boolean[m+1][n];
        return isMatch(s,0,p,0);
    }
    
    boolean isMatch(String s, int sIndex, String p, int pIndex){
        
        if(sIndex==m && pIndex==n) return true;
        if(pIndex==n) return false;
        
        if(grid[sIndex][pIndex]!=null) return grid[sIndex][pIndex];
        // '?' or a==a
        if(sIndex<m && (s.charAt(sIndex)==p.charAt(pIndex) || p.charAt(pIndex)=='?'))
            grid[sIndex][pIndex]=isMatch(s,sIndex+1,p,pIndex+1);
        //'*'
        else if(p.charAt(pIndex)=='*'){
            
            grid[sIndex][pIndex]=Boolean.FALSE;
            
            //Skip 0,1 ... m
            for(int i=sIndex;i<=m;i++){
                boolean val=isMatch(s,i,p,pIndex+1);
                if(val){
                    grid[sIndex][pIndex]=Boolean.TRUE;
                    break;
                } 
            }
            
        }
        else grid[sIndex][pIndex]=Boolean.FALSE;
        return grid[sIndex][pIndex];
    }
    
}