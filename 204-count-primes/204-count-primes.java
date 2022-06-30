class Solution {
    public int countPrimes(int n) {
        boolean[] number=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(number[i]) continue;
            count++;
            mark(i,n,number);
        }
        return count;
    }
    
    private void mark(int i,int n,boolean[] number){
        int j=2;
        int num;
        while(true){
            num=i*j;
            if(num>=n) break;
            number[num]=true;
            j++;
        }
    }
    
}