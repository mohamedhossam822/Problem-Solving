class Solution {
    public int minPartitions(String n) {
        char max='1';
        for(int i=0;i<n.length();i++){
            char curr=n.charAt(i);
            if(curr>max) max=curr;
        }
        return Character.getNumericValue(max);
    }
}