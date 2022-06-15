class Solution {
    int max;
    public int longestStrChain(String[] words) {
        max=1;
        int n=words.length;
        if(n==0) return 0;
        Arrays.sort(words, (a,b)-> a.length()-b.length());
        int[] longestPre=new int[words.length];
        for(int i=n-1;i>=0;i--){
            longestPre[i]=1;
            for(int j=i+1;j<n;j++){
                if(isPred(words[i],words[j]))
                longestPre[i]=Math.max(longestPre[i],1+longestPre[j]);
            }
            if(longestPre[i]>max) max=longestPre[i];
        }
        return max;
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