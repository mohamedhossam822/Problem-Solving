import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int L=nums.length;
        if(nums[L/2]==target) return L/2;
        else if(L == 1) return -1;
        else if(nums[L/2]>target) return search2(nums,0,L/2,target);
        else if(nums[L/2]<target) return search2(nums,L/2,L,target);
        return -1;
    }
    public int search2(int[] nums,int m,int n, int target) {
        int mean=(m+n)/2;
        if(nums[mean]==target) return mean;
        else if(m==n || n-m==1) return -1;
        else if(nums[mean]>target)return search2(nums,m,mean,target);
        else if(nums[mean]<target)return search2(nums, mean, n,target);
        return -1;
    }
}
