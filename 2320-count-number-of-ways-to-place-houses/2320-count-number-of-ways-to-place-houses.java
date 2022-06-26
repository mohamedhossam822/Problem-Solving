class Solution {
    public int countHousePlacements(int n) {
        long first=1;
        long second=1;
        long m=1000000007;
        for(int i=1;i<=n;i++){
            long temp=second;
            second=(first+second)%m;
            first=temp;
        }
        long res=(second*second)%m;
        return (int)res;
    }
}