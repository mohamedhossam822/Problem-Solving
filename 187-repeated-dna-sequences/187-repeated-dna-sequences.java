import java.util.HashSet;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> result= new HashSet<>();
        HashSet<String> strs=new HashSet<>();
        int n=s.length();
        int l=0;
        int r=9;
        String tempS;
        while(r<n){
            tempS=s.substring(l, r+1);
            if(strs.contains(tempS)){
                result.add(tempS);
                strs.add(tempS);
            }
            else strs.add(tempS);
            r++;
            l++;
        }
        return new ArrayList(result);
    }
}