import java.util.Hashtable;
class Solution {
    public boolean isAnagram(String s, String t) {
        Hashtable<Character,Integer> sFrequency=new Hashtable<>();
        char curChar;
        int frequency;
        for(int i=0;i<s.length();i++){
            curChar=s.charAt(i);
            frequency=1;
            if(sFrequency.containsKey(curChar)){
                frequency=1+sFrequency.get(curChar);
            }
            sFrequency.put(curChar,frequency);
        }
        
        for(int i=0;i<t.length();i++){
            curChar=t.charAt(i);
            if(!sFrequency.containsKey(curChar)) return false;
            frequency=sFrequency.get(curChar);
            if(frequency==1) sFrequency.remove(curChar);
            else sFrequency.put(curChar,frequency-1);
        }
        if(sFrequency.size()!=0) return false;
        return true;
    }
}