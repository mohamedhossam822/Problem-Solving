import java.util.Map.Entry;

class Solution {
    public int minDeletions(String s) {
        int max=0;
        HashMap<Character,Integer> charFreq=new HashMap<>();
        //Iterate throught string
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            int freq=1;
            if(charFreq.containsKey(curr)) freq+=charFreq.get(curr);
            if(freq>max) max=freq;
            charFreq.put(curr,freq);
        }
        int deletions=0;
        boolean[] FreqExist=new boolean[max+1];
        for(Entry<Character,Integer> entry: charFreq.entrySet()){
            int currVal=entry.getValue();
            while(FreqExist[currVal]){
                currVal--;
                deletions++;
                if(currVal==0) break;
            }
            FreqExist[currVal]=true; 
            
        }
        return deletions;
    }
}