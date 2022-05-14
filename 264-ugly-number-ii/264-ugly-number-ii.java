import java.util.HashSet;
class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int counter=1;
        int i2=0,i3=0,i5=0;
        int n2=0,n3=0,n5=0;
        ArrayList<Integer> uglyNums = new ArrayList<Integer>();
        uglyNums.add(1);
        while(counter<n){
            n2=uglyNums.get(i2);
            n3=uglyNums.get(i3);
            n5=uglyNums.get(i5);
            uglyNums.add(Math.min(Math.min(n2*2,n3*3),n5*5));
            if(uglyNums.get(counter)%2==0) i2++;
            if(uglyNums.get(counter)%3==0) i3++;
            if(uglyNums.get(counter)%5==0) i5++;
            counter++;
        }
        return uglyNums.get(counter-1);
        
    }
}