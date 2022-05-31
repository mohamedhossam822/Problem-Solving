class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n=(int)Math.pow(2,k);
        boolean[] nums=new boolean[n];
        int[] dp=new int[k];
        int temp,index,num,valsChecked=n;
        for(int i=0;i<=s.length()-k;i++){
            num=0;
            index=i;
            for(int j=k-1;j>=0;j--){
                if(s.charAt(index)=='1') {
                    if(dp[j]==0) dp[j]=(int)Math.pow(2,j); 
                    num+=dp[j];
                }
                index++;
            }
            if(!nums[num]) {
                nums[num]=true;
                valsChecked--;
                if(valsChecked==0) return true;
            }
        }
        return false;
    }
}