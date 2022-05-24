import java.util.stream.*;
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        HashSet<List> set = new HashSet<>();
        
        Hashtable<Integer,Integer> temptable=new Hashtable<>();
        ArrayList<Integer> templist=new ArrayList<>();;
        int target;
        int diff;
        for(int i=0;i<n;i++){
            templist.clear();
            templist=new ArrayList<>();
            templist.add(nums[i]);
            target=0-nums[i];
            for(int j=i+1;j<n;j++){
                diff=target-nums[j];
                if(temptable.containsKey(diff)){
                    if(temptable.get(diff)!=j && temptable.get(diff)!=i){
                        if(diff>nums[i]) {
                            if(diff>nums[j]){
                                if(nums[j]>nums[i]) templist.add(nums[j]);
                                else templist.add(0,nums[j]);
                                templist.add(diff);
                            }
                            else{
                                templist.add(diff);
                                templist.add(nums[j]);
                            }
                        }else{
                            if(diff>nums[j]){
                                templist.add(0,nums[j]);
                                templist.add(1,diff);
                            }else{
                                templist.add(0,diff);
                                if(nums[i]>nums[j]) templist.add(1,nums[j]);
                                else templist.add(nums[j]);
                            }
                            
                        } 
                        temptable.remove(diff);
                        set.add(templist);
                        templist=new ArrayList<>();
                        templist.add(nums[i]);
                    }
                }
                else temptable.put(nums[j],j);
            }
        }
        
       for (List<Integer> x : set)
            result.add(x);
        
        set.clear();
        return result;
    }
    

}