import java.util.HashSet;
class Solution {
    int maxL,maxR,maxLength;
    public String longestPalindrome(String s) {
        maxLength=1;
        int n=s.length();
        int mid=n/2;
        if(n%2==0) mid--;
        for(int i=0;i<=n/2;i++){
            ValidateString(mid+i,s,n);
            if(maxLength>=2*(mid-i+1)) break;
            if(i==0) continue;
            ValidateString(mid-i,s,n);
            if(maxLength>=2*(mid-i+1)) break;
        }
        
        return s.substring(maxL,maxR+1);
    }
    
    public void ValidateString(int i,String s,int n){
        int l=i;
        int r=i;
        int len=0;
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
}