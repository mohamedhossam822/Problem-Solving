class Solution {
    public int characterReplacement(String s, int k) {
        int temp,l=0,r=0,res=0,maxf=1;
        int[] chars=new int[26];
        chars[s.charAt(0)-'A']=1;
        while(r<s.length()){
            temp=1+r-l-maxf;
            if(temp<=k){
                if(temp+maxf>res) {
                    res=temp+maxf;
                }
                r++;
                if(r>=s.length()) break;
                chars[s.charAt(r)-'A']++;
                temp=chars[s.charAt(r)-'A'];
                if(temp>maxf) maxf=temp;
            }
            else {
              chars[s.charAt(l)-'A']--;
              l++;  
            }
            if(l>r) r=l;
        }
        return res;
    }
}