import java.util.Hashtable;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result= new ArrayList<>();
        Hashtable<String, Integer> strs=new Hashtable<>();
        int n=s.length();
        int l=0;
        int r=9;
        String tempS;
        while(r<n){
            tempS=s.substring(l, r+1);
            if(strs.containsKey(tempS)){
                if(strs.get(tempS)!=-1){
                    result.add(tempS);
                    strs.put(tempS,-1);
                }
            }
            else strs.put(tempS,1);
            r++;
            l++;
        }
        return result;
    }
}