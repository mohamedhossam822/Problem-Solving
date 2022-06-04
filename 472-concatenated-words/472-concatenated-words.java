class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> Dict=new HashSet<>();
        List<String> res=new LinkedList<>();
        String[] subStrings;
        String toCheck;
        //Add all strings to hashset
        for(int i=0;i<words.length;i++)
            Dict.add(words[i]);
        //Travers through each string
        for(int i=0;i<words.length;i++){
            if(canForm(words[i],Dict)) res.add(words[i]);
        }
        return res;
            
    }
    
    public boolean canForm(String s,HashSet<String> Dict){
        String left,right;
        for(int j=0;j<s.length()-1;j++)
        {
            left=s.substring(0,j+1);
            right=s.substring(j+1,s.length());
            //Each sub word is either in the dict or can be divided into further sub arrays
            //The reason we dnt check for canform(left) is bec 
            //by the end of the loop we will already have checked every possible substring
            if(Dict.contains(left))
                if(Dict.contains(right) || canForm(right,Dict)) 
                    return true;
        }
        return false;
    }
}