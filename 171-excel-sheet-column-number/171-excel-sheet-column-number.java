class Solution {
    public int titleToNumber(String columnTitle) {
        int res=0;
        int n=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            int num=columnTitle.charAt(i)-'A'+1;
            res+=(num*Math.pow(26,n));
            n++;
        }
        return res;
    }
}