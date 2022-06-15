import java.util.stream.*;
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l,r,sum,n=nums.length,target=-1;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp;
        
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(nums[i]>0) break;
            if(target==0-nums[i]) continue;
            target=0-nums[i];
            l=i+1;
            r=n-1;
            while(l<r){
               sum=nums[l]+nums[r];
                if(sum==target){
                    temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    result.add(temp);
                    l++;
                    while(l<n && nums[l-1]==nums[l]) l++; 
                    r--;
                    while(r>=0 && nums[r]==nums[r+1]) r--; 
                }
                else if(sum>target){
                    r--;
                    while(r>=0 && nums[r]==nums[r+1]) r--; 
                }
                else{
                    l++;
                    while(l<n &&  nums[l-1]==nums[l]) l++;  
                }
            }
        }
        return result;
    }
    

}