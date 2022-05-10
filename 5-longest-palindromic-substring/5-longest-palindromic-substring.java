import java.util.HashSet;
class Solution {
    public String longestPalindrome(String s) {
        char curCh;
        char curCh2;
        
        int maxLength=0;
        String maxPal="";
        
        int l;
        int r;
        for(int i=0;i<s.length();i++){
            l=i;
            r=i;
            while(l>-1 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLength){
                    maxLength=r-l+1;
                    maxPal=s.substring(l,r+1);
                }
                r++;
                l--;
            }
            l=i;
            r=i+1;
            while(l>-1 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>maxLength){
                    maxLength=r-l+1;
                    maxPal=s.substring(l,r+1);
                }
                r++;
                l--;
            }
                
        }
        
        return maxPal;
    }
}