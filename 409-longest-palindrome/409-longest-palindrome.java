import java.util.Hashtable;
class Solution {
    public int longestPalindrome(String s) {
        Hashtable <Character, Integer> chrFreq=new Hashtable<>();
        int counter=0;
        char c;
        
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(chrFreq.containsKey(c))
            {
                chrFreq.remove(c);
                counter+=2;
            }
            else chrFreq.put(c,1);
        }
        if(chrFreq.size()>0) counter++;
        return counter;
        
    }
}