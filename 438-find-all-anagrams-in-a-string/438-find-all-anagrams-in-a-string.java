class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int i,f,n=p.length();
        List<Integer> res=new  ArrayList<>();
        int[] numP=new int[26];
        int[] numS=new int[26];
        
        for(i=0;i<p.length();i++){
            numP[p.charAt(i)-97]++;
        }
        f=0;
        for(i=0;i<s.length();i++){
            if(i<n || s.charAt(i)!=s.charAt(i-n)){
                f=0;
                numS[s.charAt(i)-97]++;
                if(i-n>=0)  numS[s.charAt(i-n)-97]--;
            }
            if(f==1) continue;
            for(int j=0;j<26;j++){
                if(numS[j]!=numP[j]){
                    f=1;
                    break; 
                }   
            }
            if(f==0) res.add(i-n+1);
        }
        
        
        
        return res;
    }
}