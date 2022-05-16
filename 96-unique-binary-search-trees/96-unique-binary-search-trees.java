import java.util.HashMap;
class Solution {
    HashMap<Integer,Integer> cache;
    public int numTrees(int n) {
        cache=new HashMap<>();
        return num(n);
    }
    private int num(int n){
        if(cache.containsKey(n)) return cache.get(n);
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 5;
        if(n==4) return 14;
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=sum+numTrees(i-1)*numTrees(n-i);
        }
        cache.put(n,sum);
        return sum;
    }
}