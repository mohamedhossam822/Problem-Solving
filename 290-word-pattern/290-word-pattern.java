import java.util.Hashtable;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Hashtable<Character,String> hs=new Hashtable<>();
        Hashtable<String,Character> hs2=new Hashtable<>();
        String[] arrOfStr = s.split(" ");
        if(arrOfStr.length!=pattern.length()) return false;
        int n=arrOfStr.length;
        char ch;
        for(int i=0;i<n;i++){
            ch=pattern.charAt(i);
            if(!hs.containsKey(ch) && !hs2.containsKey(arrOfStr[i])){
                hs.put(ch,arrOfStr[i]);
                hs2.put(arrOfStr[i],ch);
            }
            else{
                if(!hs.containsKey(ch)) return false;
                if(!hs2.containsKey(arrOfStr[i])) return false;
                if(!hs.get(ch).equals(arrOfStr[i]) || !hs2.get(arrOfStr[i]).equals(ch)) 
                    return false;
            }
            System.out.println(hs.entrySet());
            System.out.println(hs2.entrySet());
        }
        return true;
    }
}