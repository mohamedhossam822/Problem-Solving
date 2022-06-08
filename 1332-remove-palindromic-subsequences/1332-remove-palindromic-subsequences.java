class Solution {
    public int removePalindromeSub(String s) {
        if(s.equals("")) return 0;
        int l=0;
        int r=s.length()-1;
        while(s.charAt(l)==s.charAt(r)){
            if(l>=r) return 1;
            l++;
            r--;
        }
        return 2;
        
    }
}