class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        for(int i=right-1;i>=left;i--){
            right&=i;
            i=right;
        }
        return right;
    }
}