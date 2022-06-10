class Solution {
    int[] nums;
    int size;
    public Solution(int[] nums) {
        this.nums=nums;
        size=nums.length;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        int[] tempArray=nums.clone();
        Random rnd = ThreadLocalRandom.current();
        for (int i = size - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          int temp = tempArray[index];
          tempArray[index] = tempArray[i];
          tempArray[i] = temp;
        }
        return tempArray;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */