class Solution {
    public int countVowelStrings(int n) {
        int sum=0;
        for(int i=0;i<5;i++) sum+=countVowelStrings(i,n);
        return sum;
    }
     public int countVowelStrings(int i,int n){
         if(n==1) return 1;
         int sum=0;
         for(int j=i;j<5;j++) sum+=countVowelStrings(j,n-1);
         return sum;
     }
}