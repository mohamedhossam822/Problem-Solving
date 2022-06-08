class Solution {
    int[][] grid;
    public int countVowelStrings(int n) {
        int[] pre=new int[5];
        int[] cur=new int[5];
        int sum=0;
        for(int i=0;i<n;i++){
            cur[0]=1;
            for(int j=1;j<5;j++){
                cur[j]=cur[j-1]+pre[j];
                if(i==n-1) sum+=cur[j];
            }
            pre=cur.clone();
        }
        return sum+1;
    }
}