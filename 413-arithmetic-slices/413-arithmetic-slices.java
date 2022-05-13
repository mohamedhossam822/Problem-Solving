class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2) return 0;
        int sum=0;
        int incby=1;
        int difference=nums[1]-nums[0];
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==difference){
                sum=sum+incby;
                incby++;
            } 
            else{
                difference=nums[i]-nums[i-1];
                incby=1;
            }
        }
        return sum;
    }
}

//1,3,6,10,15