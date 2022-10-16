class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sMappings=new HashMap<>();
        HashMap<Character,Character> tMappings=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            
            char sCh=s.charAt(i);
            char tCh=t.charAt(i);
            
            if(!sMappings.containsKey(sCh) && !tMappings.containsKey(tCh)){
                sMappings.put(sCh,tCh);
                tMappings.put(tCh,sCh);
            }
            else if(!sMappings.containsKey(sCh) || !tMappings.containsKey(tCh)) return false;
            else if(sMappings.get(sCh)!=tCh || tMappings.get(tCh)!=sCh) return false; 
            
        }
        
        return true;
    }
}