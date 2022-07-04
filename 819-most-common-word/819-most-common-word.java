class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        int max=0;
        String maxWord="";
        HashMap<String,Integer> dict=new HashMap<>();
        HashSet<String> bannedWords=new HashSet<>();
        for(int i=0;i<banned.length;i++) bannedWords.add(banned[i]);
        
        String[] words = paragraph.split("[\\p{Punct}\\s]+");
        for(int i=0;i<words.length;i++){
            String curr= words[i].toLowerCase();
            if(bannedWords.contains(curr)) continue;
            int freq=1;
            if(dict.containsKey(curr)) freq+=dict.get(curr);
            dict.put(curr,freq);
            if(freq>max){
                max=freq;
                maxWord=curr;
            }
        }
        
        return maxWord;
        
    }
}