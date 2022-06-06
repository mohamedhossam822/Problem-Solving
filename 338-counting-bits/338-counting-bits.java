class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        for(int i=0;i<=n;i++){
            String bin = Integer.toBinaryString(i);
            for(char c: bin.toCharArray()){
                if(c=='1') res[i]++;
            }
        }
        return res;
    }
}