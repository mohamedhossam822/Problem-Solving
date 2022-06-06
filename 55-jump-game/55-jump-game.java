class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] stairValid=new boolean[n];
        stairValid[n-1]=true;
        //Top down approach to cheack if I can reach any true stair from my point
        //If I can hp between true points then i can reach the end
        for(int i=n-2;i>=0;i--){
            for(int j=1;j<=nums[i];j++)
            {
                if(j==n) break;
                if(stairValid[i+j]) {
                    stairValid[i]=true;
                    break;
                }
            }
        }
        return stairValid[0];
    }
}