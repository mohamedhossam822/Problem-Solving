import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        int longestLength=0;
        int firstIndex=0;
        int counter=0;
        
        for(int i=0;i<s.length();i++){
            
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(firstIndex));
                counter--;
                firstIndex++;
            }
            
            set.add(s.charAt(i));
            counter++;
            if(counter>longestLength) 
                longestLength=counter;
        }
        return longestLength;
    }
}