import java.util.HashMap;
class Solution {
    int[] cache;
    public int numTrees(int n) {
        cache=new int[n+1];
        cache[0]=1;
        return num(n);
    }
    private int num(int n){
        if(cache[n]!=0) return cache[n];
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+num(i-1)*num(n-i);
        }
        cache[n]=sum;
        return sum;
    }
}