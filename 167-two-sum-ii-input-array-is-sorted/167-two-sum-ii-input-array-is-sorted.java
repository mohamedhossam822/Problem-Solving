class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int min=0;
        int max=numbers.length-1;
        int sum=numbers[min]+numbers[max];
        while(sum!=target){
            if(sum>target) max--;
            else min++;
            sum=numbers[min]+numbers[max];
        }
        return new int[]{min+1,max+1};
    }
}