import java.util.*;
class Solution {
    public int romanToInt(String s) {
        int sum=0;
        Hashtable<Character, Integer> romanNumber = new Hashtable();
        
        romanNumber.put('I',1);
        romanNumber.put('V',5);
        romanNumber.put('X',10);
        romanNumber.put('L',50);
        romanNumber.put('C',100);
        romanNumber.put('D',500);
        romanNumber.put('M',1000);
        
        if(s.length()==1) return romanNumber.get(s.charAt(0));
        
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(i+1<s.length()  && romanNumber.get(ch)<romanNumber.get(s.charAt(i+1))){
                sum=sum-romanNumber.get(ch);
            }
            else sum=sum+romanNumber.get(ch);
        }
        return sum;
    }
}