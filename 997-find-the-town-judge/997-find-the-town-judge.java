import java.util.HashSet; // import the HashMap class
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] people=new int[n+1];
        people[0]=-1;
        int l=trust.length;
        for(int i=0;i<l;i++){
            people[trust[i][0]]=-1-n;
            people[trust[i][1]]++;
        }
        for(int i=1;i<n+1;i++){
            if(people[i]==n-1)   return i;
        }
        return -1;
    }
}