import java.util.HashSet;
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        int counter=0;
        char c;
        
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(hs.contains(c))
            {
                hs.remove(c);
                counter+=2;
            }
            else hs.add(c);
        }
        if(hs.size()>0) counter++;
        return counter;
        
    }
}