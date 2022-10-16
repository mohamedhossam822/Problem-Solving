class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        if(n==0) return true;
        if(n>t.length()) return false;
        int sIndex=0;
        char c=s.charAt(0);
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==c){
                sIndex++;
                if(sIndex==n) return true;
                c=s.charAt(sIndex);
            }
        }
        return false;
    }
}