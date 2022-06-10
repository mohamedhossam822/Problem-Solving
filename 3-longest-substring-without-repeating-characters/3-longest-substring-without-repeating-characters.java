import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] charFreq=new char[128];
        int longestLength=0;
        int firstIndex=0;
        int counter=0;
        
        for(int i=0;i<s.length();i++){
            
            while(charFreq[s.charAt(i)]>0){
                charFreq[s.charAt(firstIndex)]--;
                counter--;
                firstIndex++;
            }
            
            charFreq[s.charAt(i)]++;
            counter++;
            if(counter>longestLength) 
                longestLength=counter;
        }
        return longestLength;
    }
}