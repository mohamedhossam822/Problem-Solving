class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i= s.length()-1;
        int j= t.length()-1;
        int nSkipped;
        while(i>=0 || j>=0){
            nSkipped=0;
            while(i>-1 && (s.charAt(i)=='#' || nSkipped>0)){
                if(s.charAt(i)=='#')    nSkipped++;
                else nSkipped--;
                i--;
                
            }
            
            nSkipped=0;
            while(j>-1  && (t.charAt(j)=='#' || nSkipped>0)){
                if(t.charAt(j)=='#')    nSkipped++;
                else nSkipped--;
                j--;
            }
            if(i>-1 && j>-1) {
              if(s.charAt(i)!=t.charAt(j)) return false;
            }else{
                if(i<0 && j<0) return true;
                if(i>-1 && s.charAt(i)!='#') return false;
                if(j>-1 && s.charAt(j)!='#') return false;
                
            }
            i--;
            j--;  
            
        }
        return true;
    }
}