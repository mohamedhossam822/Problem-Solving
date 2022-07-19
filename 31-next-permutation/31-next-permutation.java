class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1) Arrays.sort(nums);
        else{
            int number=nums[index];
            int repIndex=index+1;
            int repNumer=nums[index+1];
            for(int i=index+2;i<n;i++){
                if(number<nums[i]){
                    if(nums[i]<=repNumer){
                        repIndex=i;
                        repNumer=nums[i];
                    }
                }
            }
            nums[index]=repNumer;
            nums[repIndex]=number;
            int l=index+1;
            int r=n-1;
            while(l<r){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
                r--;
            }
        }
    }
}