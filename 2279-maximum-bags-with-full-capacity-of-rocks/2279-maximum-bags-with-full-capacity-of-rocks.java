class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        int i;
        int[] arr=new int[n];
        for(i=0;i<n;i++) arr[i]=capacity[i]-rocks[i];
        Arrays.sort(arr);
        int res=0;
        i=0;
        while(additionalRocks>0 && i<n){
            if(additionalRocks-arr[i]>=0){
                res++;
                additionalRocks=additionalRocks-arr[i];
            } 
            i++;
        }
        return res;
    }
}