import java.util.Hashtable;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Hashtable<Character,String> hs=new Hashtable<>();
        String[] arrOfStr = s.split(" ");
        if(arrOfStr.length!=pattern.length()) return false;
        int n=arrOfStr.length;
        char ch;
        for(int i=0;i<n;i++){
            ch=pattern.charAt(i);
            if(!hs.containsKey(ch)){
                if(hs.containsValue(arrOfStr[i])) return false;
                hs.put(ch,arrOfStr[i]);
            }
            else{
                if(!hs.get(ch).equals(arrOfStr[i])) 
                    return false;
            }
        }
        return true;
    }
}