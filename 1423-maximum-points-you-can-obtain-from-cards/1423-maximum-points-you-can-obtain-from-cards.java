class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int minSum=0;
        int window=0;
        int lenMin=cardPoints.length-k;
        for(int i=0;i<lenMin;i++){
            sum+=cardPoints[i];
            minSum+=cardPoints[i];
        }
        window=minSum;
        int firstElement=0;
        for(int i=lenMin;i<cardPoints.length;i++){
            sum+=cardPoints[i];
            window+=cardPoints[i];
            window-=cardPoints[firstElement];
            firstElement++;
            if(window< minSum) minSum=window;
        }
        
        return sum-minSum;
    }
}