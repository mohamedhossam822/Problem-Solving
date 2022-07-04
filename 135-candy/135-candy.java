class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int numberOfCandies=0;
        int[] children=new int[n];
        children[0]=1;
        for(int i=1;i<n;i++){
            children[i]=1;
            if(ratings[i]>ratings[i-1]) children[i]+=children[i-1];
        }
        numberOfCandies+=children[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                children[i]=Math.max(children[i],children[i+1]+1);
            }
            numberOfCandies+=children[i];
        }
        
        return numberOfCandies;
    }
}