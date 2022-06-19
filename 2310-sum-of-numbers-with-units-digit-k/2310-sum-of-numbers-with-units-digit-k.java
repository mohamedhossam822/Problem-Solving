class Solution {
    HashMap<Integer,Integer> cache=new HashMap<>();
    public int minimumNumbers(int num, int k) {
        if(cache.containsKey(num)) return cache.get(num);
        if(num==0) return 0;
        if(num%10==k) return 1;
        if(k==0) return -1;
        int val,min=Integer.MAX_VALUE;
        for(int i=k;i<num;i+=10){
            val=minimumNumbers(num-i,k);
            if(val==-1) continue;
            min=Math.min(val+1,min);
        }
        if(min==Integer.MAX_VALUE) {
            cache.put(num,-1);
                return -1; 
        }
        cache.put(num,min);
        return min;
    }
}