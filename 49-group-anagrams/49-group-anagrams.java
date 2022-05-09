import java.util.Hashtable;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        int n=strs.length;
        Str[] sortedStrs=new Str[n];
        char[] tempArray;
        //Sort all strings
        for(int i=0;i<n;i++){
            tempArray = strs[i].toCharArray();
            Arrays.sort(tempArray);
            sortedStrs[i]=new Str(new String(tempArray),i);
        }
        //Sort th resultant array of strings
         Arrays.sort(sortedStrs, new Comparator<Str>() {
           public int compare(Str b1, Str b2) {
               return (b1.s).compareTo(b2.s);
           }
        });
        List<String> newEntry=new ArrayList<>();
        newEntry.add(strs[sortedStrs[0].index]);
        for(int i=1;i<n;i++){
            if(sortedStrs[i].s.equals(sortedStrs[i-1].s)){
                newEntry.add(strs[sortedStrs[i].index]);
            }
            else{
                result.add(newEntry);
                newEntry=new ArrayList<>();
                newEntry.add(strs[sortedStrs[i].index]);
            }
            
        }
        result.add(newEntry);
        return result;
    }
}

class Str{
    String s;
    int index;
    public Str(String s,int index){
        this.s=new String(s);
        this.index=index;
    }
}