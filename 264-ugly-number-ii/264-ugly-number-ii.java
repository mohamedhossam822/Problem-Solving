import java.util.HashSet;
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int counter=1;
        int i2=0,i3=0,i5=0;
        int n2=0,n3=0,n5=0;
        int[] uglyNums=new int[n];
        uglyNums[0]=1;
        while(counter<n){
            n2=uglyNums[i2]*2;
            n3=uglyNums[i3]*3;
            n5=uglyNums[i5]*5;
            uglyNums[counter]=Math.min(Math.min(n2,n3),n5);
            if(uglyNums[counter]%2==0) i2++;
            if(uglyNums[counter]%3==0) i3++;
            if(uglyNums[counter]%5==0) i5++;
            counter++;
        }
        return uglyNums[n-1];
        
    }
}