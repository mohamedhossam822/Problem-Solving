class Solution {
    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> Dict=new HashSet<>();
        result=new ArrayList<>();
        int minSize=Integer.MAX_VALUE;
        for(String word : wordDict){
            minSize=Math.min(word.length(),minSize);
            Dict.add(word); 
        }
        getAll(minSize-1,Dict,s,0,new StringBuilder());
        return result;
    }
    
    private void getAll(int minSize,HashSet<String> Dict,String s,int start,StringBuilder str){
        for(int i=start+minSize;i<s.length();i++){
            String temp=s.substring(start,i+1);
            if(Dict.contains(temp)){
                
                str.append(temp);
                //Found the end
                if((i+1)==s.length()) result.add(new String(str.toString()));
                
                str.append(" ");
                getAll(minSize,Dict,s,i+1,str);
                
                //BackTrack
                str.delete(str.length()-temp.length()-1,str.length());
            }   
        }
    }
}