class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> Dict=new HashSet<>();
        List<String> res=new LinkedList<>();
        String[] subStrings;
        String toCheck;
        int min = Integer.MAX_VALUE;
        //Add all strings to hashset
        for(int i=0;i<words.length;i++){
            if(words[i].length()<min) min=words[i].length();
            Dict.add(words[i]);
        }
        if(min==0) min=1;
        //Travers through each string
        for(int i=0;i<words.length;i++){
            if(canForm(min,words[i],Dict)) res.add(words[i]);
        }
        return res;
            
    }
    
    public boolean canForm(int min,String s,HashSet<String> Dict){
        String left,right;
        for(int j=min;j<=s.length()-min;j++)
        {
            left=s.substring(0,j);
            right=s.substring(j,s.length());
            //Each sub word is either in the dict or can be divided into further sub arrays
            //The reason we dnt check for canform(left) is bec 
            //by the end of the loop we will already have checked every possible substring
            if(Dict.contains(left))
                if(Dict.contains(right) || canForm(min,right,Dict)){
                    Dict.add(right);
                    return true;
                } 
                    
        }
        return false;
    }
}