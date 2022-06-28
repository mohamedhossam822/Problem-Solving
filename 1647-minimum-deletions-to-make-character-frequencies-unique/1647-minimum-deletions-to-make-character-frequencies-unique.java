import java.util.Map.Entry;

class Solution {
    public int minDeletions(String s) {
        int max=0;
        int[] frequency = new int[26];
        //Iterate throught string
        for (int i = 0; i < s.length(); i++) {
            char curr=s.charAt(i);
            frequency[curr- 'a']++;
            if(frequency[curr- 'a']>max) max=frequency[curr- 'a'];
        }
        
        int deletions=0;
        
        boolean[] FreqExist=new boolean[max+1];
        
        for(int i=0;i<26;i++){
            int currVal=frequency[i];
            if(currVal==0) continue;
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