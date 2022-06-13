class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len=beginWord.length();
        HashSet<String> dict=new HashSet<>();
        HashSet<String> Visited=new HashSet<>();
        List<HashSet<Character>> charList=new ArrayList<>(len);
        for(int i=0;i<len;i++) charList.add(new HashSet<>());
        for(int i=0;i<wordList.size();i++){
            for(int j=0;j<len;j++){
                charList.get(j).add(wordList.get(i).charAt(j));
            }
            dict.add(wordList.get(i));
        }
        
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int counter=2;
        while(!q.isEmpty()){
            int size=q.size();
            while(size>0){
                StringBuilder str=new StringBuilder(q.poll());
                for(int i=0;i<len;i++){
                    char ch=str.charAt(i);
                    for(char c:charList.get(i)){
                        if(c==ch) continue;
                        str.setCharAt(i,c);
                        String resString=str.toString();
                        if(resString.equals(endWord)) return counter;
                        if(dict.contains(resString) && !Visited.contains(resString)){
                            q.add(resString);
                            Visited.add(resString);
                        }
                    }
                    str.setCharAt(i,ch);
                }
                size--;
            }
            counter++;
        }
        
        return 0;
    }
}