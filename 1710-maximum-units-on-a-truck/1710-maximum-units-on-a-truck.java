class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int numberOfUnits=0;
        //Sort the array according to the number of units
        Arrays.sort(boxTypes,(a,b)-> a[1]>b[1] ? -1 : 1);
        //Take the most of each bos type
        for(int[] box: boxTypes){
            if(truckSize>box[0]){
                numberOfUnits+=(box[0]*box[1]);
                truckSize-=box[0];
            }else{
                numberOfUnits+=(truckSize*box[1]);
                break;
            }
        }
        
        return numberOfUnits;
    }
}