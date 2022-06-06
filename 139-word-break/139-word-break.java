class Solution {
    boolean[] cache;
    boolean[] cacheCh;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        cache=new boolean[n];
        cacheCh=new boolean[n];
        return findWord(s,n,0,wordDict);
    }
    private boolean findWord(String s,int n,int index, List<String> wordDict){
        if(index==n) return true;
        if(cache[index]) return cacheCh[index];
        int temp=0;
        boolean val;
        for(int i=0;i<wordDict.size();i++){
            temp=wordDict.get(i).length();
            if(temp+index>n) continue;
            if(s.substring(index,temp+index).equals(wordDict.get(i))){
                val=findWord(s,n,temp+index,wordDict);
                cache[index]=true;
                cacheCh[index]=val;
                if(val) return true;
            }   
        }
        cache[index]=true;
        cacheCh[index]=false;
        return false;
    }
}