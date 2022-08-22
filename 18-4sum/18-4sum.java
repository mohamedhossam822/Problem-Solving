class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int index=-1;
        int index2=-1;
        int ogTarget=target;
        for(int  i=0;i<nums.length-3;i++){
            
            if(index>=0 && nums[i]==nums[index]) continue;
            long newtarget1=target-nums[i];
            
            for(int  j=i+1;j<nums.length-2;j++){
                if(index2>=0 && nums[j]==nums[index2]) continue;
                long newtarget=newtarget1-nums[j];
                
                //2sum
                int l=j+1;
                int r=nums.length-1;
                
                
                while(l<r){
                    long sum=nums[l]+nums[r];
                    if(sum==newtarget){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        res.add(temp);
                        int left=nums[l];
                        int right=nums[r];
                        while(l<nums.length && left==nums[l]) l++;
                        while(r>l && right==nums[r]) r--;
                    }
                    else if(sum<newtarget) l++;
                    else r--;
                }
                index2=j;
            }
            index2=-1;
            index=i;
        }
        
        return res;
    }
}