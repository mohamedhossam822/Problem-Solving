class Solution {
    int max;
    public int longestStrChain(String[] words) {
        max=1;
        int n=words.length;
        if(n==0) return 0;
        Arrays.sort(words, (a,b)-> a.length()-b.length());
        int[] longestPre=new int[words.length];
        for(int i=0;i<n;i++){
            if(longestPre[i]==0) getMaxPred(i,new HashSet<Integer>(),words,longestPre,n);
        }
        return max;
    }
    
    public int getMaxPred(int index,HashSet<Integer> visited,String[] words,int[] longestPre,int n){
        if(longestPre[index]!=0) return longestPre[index];
        longestPre[index]=1;
        visited.add(index);
        for(int i=index+1;i<n;i++){
            if(visited.contains(i)) continue;
            if(isPred(words[index],words[i]))
            longestPre[index]=Math.max(longestPre[index],1+getMaxPred(i,visited,words,longestPre,n));
        }
        if(longestPre[index]>max) max=longestPre[index];
        return longestPre[index];
    }
    
    //Check if word1 isPred to word2
    public boolean isPred(String word1,String word2){
        if(word2.length()!=word1.length()+1) return false;
        int pass=1;
        int i=0,j=0;
        while(i<word1.length()){
            if(word1.charAt(i)==word2.charAt(j)){
                i++;
                j++;
            }
            else if(pass==0) return false;
            else{
                pass--;
                j++;
            }
        }
        return true;
    }
}