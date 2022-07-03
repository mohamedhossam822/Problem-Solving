class Solution {
    public int wiggleMaxLength(int[] nums) {
        int max=1;
        int n=nums.length;
        int[] Negative=new int[n];
        int[] Postive=new int[n];
        for(int i=n-1;i>=0;i--){
            Negative[i]=1;
            Postive[i]=1;
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                    Negative[i]=Math.max(1+Postive[j],Negative[i]);
                    if(Negative[i]>max) max=Negative[i];
                }
                else if(nums[i]<nums[j]){
                    Postive[i]=Math.max(1+Negative[j],Postive[i]); 
                    if(Postive[i]>max) max=Postive[i];
                }
            }
        }
        
        return max;
    }
}