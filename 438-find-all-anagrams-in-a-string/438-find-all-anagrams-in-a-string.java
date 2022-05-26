class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char c;
        int n,i,f,nP=p.length();
        List<Integer> res=new  ArrayList<>();
        HashSet<Character> pCharSet=new HashSet<>();
        char[] pChar;
        HashMap<Character,Integer> pFreq=new HashMap<>();
        HashMap<Character,Integer> sFreq=new HashMap<>();
        for(i=0;i<p.length();i++){
            c=p.charAt(i);
            pCharSet.add(c);
            if(pFreq.containsKey(c)) pFreq.put(c,pFreq.get(c)+1);
            else pFreq.put(c,1);
        }
        
        n=pCharSet.size();
        pChar=new char[n];
        i=0;
        f=0;
        for (char ch : pCharSet) {
            pChar[i]=ch;
            i++;
        }
        for(i=0;i<s.length();i++){
            if(i<nP || s.charAt(i)!=s.charAt(i-nP)){
                f=0;
                c=s.charAt(i);
                if(sFreq.containsKey(c)) sFreq.put(c,sFreq.get(c)+1);
                else sFreq.put(c,1);
                if(i-nP>=0)  sFreq.put(s.charAt(i-nP),sFreq.get(s.charAt(i-nP))-1);
            }
            if(f==1) continue;
            for(int j=0;j<n;j++){
                c=pChar[j];
                if(!sFreq.containsKey(c) || sFreq.get(c).intValue()!=pFreq.get(c).intValue()){
                    f=1;
                    break;
                }
            }
            if(f==0) res.add(i-nP+1);
        }
        
        
        
        return res;
    }
}