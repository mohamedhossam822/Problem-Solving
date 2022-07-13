class Solution {
    Boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        cache=new Boolean[n];
        return findWord(s,n,0,wordDict);
    }
    private Boolean findWord(String s,int n,int index, List<String> wordDict){
        if(index==n) return true;
        if(cache[index]!=null) return cache[index];
        int temp=0;
        cache[index]=false; 
        for(int i=0;i<wordDict.size();i++){
            temp=wordDict.get(i).length();
            if(temp+index>n) continue;
            if(s.substring(index,temp+index).equals(wordDict.get(i))){
                cache[index]=cache[index] || findWord(s,n,temp+index,wordDict);
            }   
        }
        return cache[index];
    }
}