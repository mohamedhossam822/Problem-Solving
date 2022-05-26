public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum=0;
        int bit=1;
        for(int i=0;i<32;i++){
            if((n & bit)==bit) sum++;
            bit=bit*2;
        }
        return sum;
    }
}