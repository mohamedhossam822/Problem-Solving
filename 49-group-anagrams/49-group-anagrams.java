import java.util.Hashtable;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        List<String> temp;
        char[] tempArray;
        String s;
        int counter=0;
        HashMap<String,Integer> keyIndex=new HashMap<>();
        
        for(int i=0;i<strs.length;i++){
            tempArray  = new char[26];
            for(char c: strs[i].toCharArray()) {
                tempArray[c - 'a']++;
            }
            s=new String(tempArray);
            if(keyIndex.containsKey(s)) result.get(keyIndex.get(s)).add(strs[i]);
            else{
                temp=new ArrayList<>();
                temp.add(strs[i]);
                result.add(temp);
                keyIndex.put(s,counter);
                counter++;
            }
        }
        return result;
    }
}
