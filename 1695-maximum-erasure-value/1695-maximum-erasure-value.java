class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> numbers=new HashSet<>();
        numbers.add(nums[0]);
        int max=nums[0];
        int sum=nums[0];
        int firstIndex=0;
        int number;
        for(int i=1;i<nums.length;i++){
            number=nums[i];
            while(numbers.contains(number)){
                numbers.remove(nums[firstIndex]);
                sum-=nums[firstIndex];
                firstIndex++;
            }
            numbers.add(number);
            sum+=number;
            if(sum>max) max=sum;
        }
        
        return max;
    }
}