
class Solution {
    public boolean isAnagram(String s, String t) {
        if(t.length()!=s.length()) return false;
        int[] chars=new int[26];
        int i;
        for(i=0;i<s.length();i++){
            chars[s.charAt(i)-97]++;
        }
        
        for(i=0;i<t.length();i++){
            chars[t.charAt(i)-97]--;
        }
        for(i=0;i<26;i++)
            if(chars[i]!=0) return false;
        return true;
    }
}