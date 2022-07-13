class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max1=0;
        int max2=0;
        int max=0;
        for(int i=0;i<values.length;i++){
            int val=values[i]+i;
            int val2=values[i]-i;
            if(max1+val2>max) max=max1+val2;
            if(val>max1) max1=val;
            
        }
        
        return max;
    }
}