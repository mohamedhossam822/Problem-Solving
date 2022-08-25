import java.util.Hashtable;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Hashtable<Character,Integer> magazineFrequency=new Hashtable<>();
        char curChar;
        int frequency;
        for(int i=0;i<magazine.length();i++){
            curChar=magazine.charAt(i);
            frequency=1;
            if(magazineFrequency.containsKey(curChar)){
                frequency=1+magazineFrequency.get(curChar);
            }
            magazineFrequency.put(curChar,frequency);
        }
        
        for(int i=0;i<ransomNote.length();i++){
            curChar=ransomNote.charAt(i);
            if(!magazineFrequency.containsKey(curChar)) return false;
            frequency=magazineFrequency.get(curChar);
            if(frequency==1) magazineFrequency.remove(curChar);
            else magazineFrequency.put(curChar,frequency-1);
        }
        return true;
    }
}