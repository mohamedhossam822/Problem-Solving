import java.util.HashSet;
class Solution {
    public String longestPalindrome(String s) {
        String maxPal="";
        int maxLength=0,maxL=0,maxR=0,len,l,r;
        int n=s.length();
        for(int i=0;i<n;i++){
            l=i;
            r=i;
            while(l>-1 && r<n && s.charAt(l)==s.charAt(r)){
                len=r-l+1;
                if(len>maxLength){
                    maxLength=len;
                    maxL=l;
                    maxR=r;
                }
                r++;
                l--;
            }
            
            l=i;
            r=i+1;
            while(l>-1 && r<s.length() && s.charAt(l)==s.charAt(r)){
                len=r-l+1;
                if(len>maxLength){
                    maxLength=len;
                    maxL=l;
                    maxR=r;
                }
                r++;
                l--;
            }
                
        }
        
        return s.substring(maxL,maxR+1);
    }
}