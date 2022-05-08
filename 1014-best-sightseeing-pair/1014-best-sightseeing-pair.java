class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max1=0;
        int max2=0;
        for(int i=0;i<values.length;i++){
            max2= max2> max1+values[i]-i ? max2 :max1+values[i]-i;
            max1= max1> i+values[i] ? max1 :i+values[i];
            }
        return max2;
        }
}